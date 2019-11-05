package com.java.fileboard.command;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.java.command.CommandAction;
import com.java.fileboard.dao.BoardDao;
import com.java.fileboard.dto.BoardDto;

public class UpdateOkAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(fileFactory);
		List<FileItem> fileList = fileUpload.parseRequest(request);
		Iterator<FileItem> fileIterator = fileList.iterator();
		HashMap<String, String> dataMap = new HashMap<String, String>();
		BoardDto boardDto = new BoardDto();
		BoardDto readBoardDto = null;

		while (fileIterator.hasNext()) {
			FileItem fileItem = fileIterator.next();

			if (fileItem.isFormField()) {
				String key = fileItem.getFieldName();
				String value = fileItem.getString("UTF-8");
				dataMap.put(key, value);
			} else {
				if (fileItem.getFieldName().equals("file")) {
					String fileName = fileItem.getName();

					if (fileName == null || fileName.equals(""))
						continue;

					String timeName = Long.toString(System.currentTimeMillis()) + "_" + fileName;
					fileUpload.setSizeMax(1024 * 1024 * 10);

					//String path = request.getServletContext().getRealPath("/pds");
					
					File path = new File("C:/pds/");
					path.mkdir();
					
					File file = new File(path, timeName);

					fileItem.write(file);

					boardDto.setFileName(timeName);
					boardDto.setFileSize(fileItem.getSize());
					boardDto.setPath(file.getAbsolutePath());
					
					// check old Data
					readBoardDto = BoardDao.getInstance().getBoard(Integer.parseInt(dataMap.get("boardNumber")));
					
					if (readBoardDto.getFileName() != null) {
						File oldFile = new File(readBoardDto.getPath());
						if (oldFile.exists() && oldFile.isFile()) {
							oldFile.delete();
						}
					}
					
				}
			}
		}

		boardDto.setWriteDate(new Date());
		boardDto.setDataMap(dataMap);

		int check = BoardDao.getInstance().update(boardDto);
		request.setAttribute("check", check);
		
		if(dataMap.get("pageNumber") != null) {
			request.setAttribute("pageNumber", dataMap.get("pageNumber"));
		}else {
			request.setAttribute("pageNumber", 1);
		}
		
		return "/WEB-INF/view/fileboard/updateOk.jsp";
	}

}
