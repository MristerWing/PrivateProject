package com.java.fileboard.command;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
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

public class WriteOkAction implements CommandAction {

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
		System.out.println(request.getParameter("writer"));
		while (fileIterator.hasNext()) {
			FileItem fileItem = fileIterator.next();
			// text
			if (fileItem.isFormField()) {
				if (fileItem.getFieldName().equals("boardNumber")) {
					boardDto.setBoardNumber(Integer.parseInt(fileItem.getString()));
				}

				if (fileItem.getFieldName().equals("groupNumber")) {
					boardDto.setGroupNumber(Integer.parseInt(fileItem.getString()));
				}

				if (fileItem.getFieldName().equals("sequnceNumber")) {
					boardDto.setSequenceNumber(Integer.parseInt(fileItem.getString()));
				}

				if (fileItem.getFieldName().equals("sequnceLevel")) {
					boardDto.setSequenceLevel(Integer.parseInt(fileItem.getString()));
				}

				if (fileItem.getFieldName().equals("writer")) {
					boardDto.setWriter(fileItem.getString("UTF-8"));
				}

				if (fileItem.getFieldName().equals("subject")) {
					boardDto.setSubject(fileItem.getString("UTF-8"));
				}

				if (fileItem.getFieldName().equals("email")) {
					boardDto.setEmail(fileItem.getString("UTF-8"));
				}

				if (fileItem.getFieldName().equals("content")) {
					boardDto.setContent(fileItem.getString("UTF-8"));
				}

				if (fileItem.getFieldName().equals("password")) {
					boardDto.setPassword(fileItem.getString("UTF-8"));
				}

				/*
				 * if (fileItem.getFieldName().equals("pageNumber")) {
				 * request.setAttribute("pageNumber", fileItem.getString()); } else {
				 * 
				 * }
				 */
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
					String dir = "F:\\PrivateProject\\5.MVC\\workspace\\homepage\\WebContent\\ftp";
					File file = new File(dir, fileName);

					// ftp
					BufferedInputStream bis = null;
					BufferedOutputStream bos = null;

					// int readPerByte = 1024;

					try {
						bos = new BufferedOutputStream(new FileOutputStream(file));

						if (bos != null) {
							bis = new BufferedInputStream(fileItem.getInputStream());

							while (true) {
								int fileData = bis.read();
								if (fileData == -1)
									break;
								bos.write(fileData);

							}
						}

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (bos != null)
							bos.close();
						if (bis != null)
							bis.close();
					}

					boardDto.setFileName(fileName);
					boardDto.setFileSize(fileSize);
					boardDto.setPath(file.getAbsolutePath());
				}
			}
		}

		boardDto.setWriteDate(new Date());
		boardDto.setReadCount(0);
		request.setAttribute("pageNumber", 1);
		
		int check = BoardDao.getInstance().insert(boardDto);
		request.setAttribute("check", check);
		logger.info(logMsg + boardDto.toString());
		logger.info(logMsg + check);

		return "/WEB-INF/view/fileboard/writeOk.jsp";

		//return null;
	}
}
