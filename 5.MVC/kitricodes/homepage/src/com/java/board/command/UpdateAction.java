package com.java.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.board.dao.BoardDao;
import com.java.board.dto.BoardDto;
import com.java.command.CommandAction;

public class UpdateAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		BoardDto boardDto = BoardDao.getInstance().getBoard(boardNumber);
		request.setAttribute("boardNumber", boardNumber);
		request.setAttribute("boardDto", boardDto);
		request.setAttribute("pageNumber", request.getParameter("pageNumber"));
		
		return "/WEB-INF/view/board/update.jsp";
	}

}
