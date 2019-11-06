package com.java.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.board.dao.BoardDao;
import com.java.command.CommandAction;

public class DeleteAction implements CommandAction {
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		
		int check = BoardDao.getInstance().delete(boardNumber);
		
		request.setAttribute("pageNumber", request.getParameter("pageNumber"));
		request.setAttribute("check", check);

		return "/WEB-INF/view/board/delete.jsp";
	}
}
