package com.java.fileboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.fileboard.dao.BoardDao;
import com.java.command.CommandAction;

public class DeleteAction implements CommandAction {
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		//int check = BoardDao.getInstance().delete(boardNumber);
		if(request.getParameter("fileName") != null) {
			logger.info(logMsg + request.getParameter("fileName") + request.getParameter("path"));
		}
		
		request.setAttribute("pageNumber", request.getParameter("pageNumber"));
		//request.setAttribute("check", check);

		//return "/WEB-INF/view/fileboard/delete.jsp";
		return null;
	}
}
