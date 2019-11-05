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

public class WriteOkActionMap implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 보관할 클래스
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();

		// 업로드할 클래스
		ServletFileUpload fileUpload = new ServletFileUpload(fileFactory);

		// form의 파일리스트를 받아와 순환자 패턴으로 변환
		List<FileItem> fileList = fileUpload.parseRequest(request);
		Iterator<FileItem> fileIterator = fileList.iterator();
		BoardDto boardDto = new BoardDto();
		HashMap<String, String> fileDataMap = new HashMap<String, String>();

		while (fileIterator.hasNext()) {
			FileItem fileItem = fileIterator.next();
			// text
			if (fileItem.isFormField()) {
				String key = fileItem.getFieldName();
				String value = fileItem.getString("UTF-8");
				fileDataMap.put(key, value);
			}
			// binary
			else {
				if (fileItem.getFieldName().equals("file")) {
					logger.info(logMsg + fileItem.getName());
					if (fileItem.getName() == null || fileItem.getName().equals("")) {
						continue;
					}
					// name
					String fileName = Long.toString(System.currentTimeMillis()) + "_" + fileItem.getName();

					// size
					fileUpload.setFileSizeMax(1024 * 1024 * 10);
					long fileSize = fileItem.getSize();

					// dir
					//String dir = "F:/PrivateProject/5.MVC/workspace/homepage/WebContent/ftp";
					
					//String dir = request.getServletContext().getRealPath("/pds");
					File path = new File("C:/pds/");
					path.mkdir();
					File file = new File(path, fileName);

					fileItem.write(file);

					boardDto.setFileName(fileName);
					boardDto.setFileSize(fileSize);
					boardDto.setPath(file.getAbsolutePath());
				}
			}
		}

		boardDto.setDataMap(fileDataMap);
		boardDto.setWriteDate(new Date());
		boardDto.setReadCount(0);
		
		String pageNumber = fileDataMap.get("pageNumber");
		if (pageNumber != null) {
			request.setAttribute("pageNumber", pageNumber);
		} else {
			request.setAttribute("pageNumber", 1);
		}

		int check = BoardDao.getInstance().insert(boardDto);
		request.setAttribute("check", check);
		logger.info(logMsg + boardDto.toString());
		logger.info(logMsg + check);

		return "/WEB-INF/view/fileboard/writeOk.jsp";

		// return null;
	}
}
