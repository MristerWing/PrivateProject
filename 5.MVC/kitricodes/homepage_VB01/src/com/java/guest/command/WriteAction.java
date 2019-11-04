package com.java.guest.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.guest.dao.GuestDao;
import com.java.guest.dto.GuestDto;

public class WriteAction implements CommandAction {

	// List - page기법, Write

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String pageNumber = request.getParameter("pageNumber");
		if (pageNumber == null)
			pageNumber = "1";

		int currentPage = Integer.parseInt(pageNumber); // 1page
		int boardSize = 3; // page당 출력 게시물 수
		int startRow = (currentPage - 1) * boardSize + 1; // start num
		int endRow = boardSize * currentPage; // end num
		
		logger.info(logMsg + currentPage);
		
		int count = GuestDao.getInstance().getCount();
		logger.info(logMsg + count);
		ArrayList<GuestDto> guestList = null;
		
		if(count > 0) {
			guestList = GuestDao.getInstance().guestList(startRow, endRow);
		}

		logger.info(logMsg + guestList.size());
		
		request.setAttribute("guestList", guestList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("boardSize", boardSize);
		request.setAttribute("count", count);
		

		return "/WEB-INF/view/guest/write.jsp";
	}

}
