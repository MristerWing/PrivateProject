package com.java.board.command;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.board.dao.BoardDao;
import com.java.board.dto.BoardDto;
import com.java.command.CommandAction;

public class WriteOkAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("UTF-8");

		BoardDto boardDto = new BoardDto();
		boardDto.setBoardNumber(Integer.parseInt(request.getParameter("boardNumber")));
		boardDto.setGroupNumber(Integer.parseInt(request.getParameter("groupNumber")));
		boardDto.setSequenceNumber(Integer.parseInt(request.getParameter("sequenceNumber")));
		boardDto.setSequenceLevel(Integer.parseInt(request.getParameter("sequenceLevel")));

		boardDto.setWriter(request.getParameter("writer"));
		boardDto.setSubject(request.getParameter("subject"));
		boardDto.setEmail(request.getParameter("email"));
		boardDto.setContent(request.getParameter("content"));
		boardDto.setPassword(request.getParameter("password"));

		boardDto.setWriteDate(new Date());
		boardDto.setReadCount(0);
		logger.info(logMsg + boardDto.toString());

		int check = BoardDao.getInstance().insert(boardDto);
		logger.info(logMsg + check);

		request.setAttribute("check", check);

		if (request.getParameter("pageNumber") != null) {
			request.setAttribute("pageNumber", request.getParameter("pageNumber"));
		} else {
			request.setAttribute("pageNumber", 1);
		}

		return "/WEB-INF/view/board/writeOk.jsp";
	}
}
