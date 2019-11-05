package com.java.fileboard.command;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.fileboard.dao.BoardDao;
import com.java.fileboard.dto.BoardDto;

public class DownloadAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		logger.info(logMsg + boardNumber);

		BoardDto boardDto = BoardDao.getInstance().getBoard(boardNumber);

		String dbName = boardDto.getFileName().split("_")[1];
		String fileName = new String(dbName.getBytes("UTF-8"), "ISO-8859-1");
		
		logger.info(logMsg + dbName);

		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		response.setContentType("application/octet-stream");
		response.setContentLengthLong((int) boardDto.getFileSize());
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			bis = new BufferedInputStream(new FileInputStream(boardDto.getPath()));
			bos = new BufferedOutputStream(response.getOutputStream());
			
			while(true) {
				int data = bis.read();
				if(data == -1) break;
				bos.write(data);
			}
			
			bos.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bos != null) bos.close();
			if (bis != null) bis.close();
		}

		return null;
	}

}
