package com.java.board.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.board.dao.BoardDao;
import com.java.board.dto.BoardDto;
import com.java.command.CommandAction;

public class ListAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String pageNumber = request.getParameter("pageNumber");
		if (pageNumber == null)
			pageNumber = "1";

		int currentPage = Integer.parseInt(pageNumber); // 1page
		int boardSize = 10; // page당 출력 게시물 수
		int startRow = (currentPage - 1) * boardSize + 1; // start num
		int endRow = boardSize * currentPage; // end num
		logger.info(logMsg + currentPage);

		int count = BoardDao.getInstance().getCount();
		logger.info(logMsg + count);
		List<BoardDto> boardList = null;

		if (count > 0) {
			boardList = BoardDao.getInstance().getBoardList(startRow, endRow);
		}

		logger.info(logMsg + boardList.size());

		request.setAttribute("boardList", boardList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("boardSize", boardSize);
		request.setAttribute("count", count);

		return "/WEB-INF/view/board/list.jsp";
	}

}
