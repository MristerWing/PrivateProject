package com.java.fileboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.fileboard.dao.BoardDao;
import com.java.fileboard.dto.BoardDto;
import com.java.command.CommandAction;

public class ReadAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		int pageNumber =  Integer.parseInt(request.getParameter("pageNumber"));
		logger.info(logMsg + boardNumber +"\t" + pageNumber);
		
		BoardDto boardDto = BoardDao.getInstance().read(boardNumber);
		logger.info(logMsg + boardDto.toString());
		
		if(boardDto.getFileName() != null) {
			/*
			 * int index=boardDto.getFileName().indexOf("_");
			 * boardDto.setFileName(boardDto.getFileName().substring(index));
			 */
			
			boardDto.setFileName(boardDto.getFileName().split("_")[1]);
			logger.info(logMsg + boardDto.getFileName());
		}
		
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("boardDto", boardDto);
		
		return "/WEB-INF/view/fileboard/read.jsp";
	}

}
