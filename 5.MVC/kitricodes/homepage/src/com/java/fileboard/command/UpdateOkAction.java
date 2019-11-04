package com.java.fileboard.command;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.fileboard.dao.BoardDao;
import com.java.fileboard.dto.BoardDto;
import com.java.command.CommandAction;

public class UpdateOkAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		BoardDto boardDto = new BoardDto();
		boardDto.setBoardNumber(Integer.parseInt(request.getParameter("boardNumber")));
		boardDto.setWriter(request.getParameter("writer"));
		boardDto.setSubject(request.getParameter("subject"));
		boardDto.setContent(request.getParameter("content"));
		boardDto.setPassword(request.getParameter("password"));

		boardDto.setWriteDate(new Date());
		logger.info(logMsg + boardDto.toString());

		int check = BoardDao.getInstance().update(boardDto);
		logger.info(logMsg + check);

		request.setAttribute("check", check);

		if (request.getParameter("pageNumber") != null) {
			request.setAttribute("pageNumber", request.getParameter("pageNumber"));
		} else {
			request.setAttribute("pageNumber", 1);
		}

		return "/WEB-INF/view/fileboard/updateOk.jsp";
	}

}
