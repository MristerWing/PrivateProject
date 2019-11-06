package com.java.fileboard.command;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.fileboard.dao.BoardDao;
import com.java.fileboard.dto.BoardDto;

public class DeleteAction implements CommandAction {
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		BoardDto boardDto = BoardDao.getInstance().getBoard(boardNumber);
		int check = 0;
		if (boardDto.getFileName() != null) {
			logger.info(logMsg + boardDto.getFileName() + " / " + boardDto.getPath());
			File file = new File(boardDto.getPath());

			if (file.exists() && file.isFile()) {
				file.delete();
			}
		}
		
		check = BoardDao.getInstance().delete(boardNumber);

		request.setAttribute("pageNumber", request.getParameter("pageNumber"));
		request.setAttribute("check", check);

		return "/WEB-INF/view/fileboard/delete.jsp";
		// return null;
	}
}
