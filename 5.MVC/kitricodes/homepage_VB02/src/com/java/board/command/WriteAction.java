package com.java.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;

public class WriteAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//부모글 root글
		int boardNumber = 0;	//글번호 (DB가 결정)
		int groupNumber = 1;	//그룹번호
		int sequenceNumber = 0; //글순서
		int sequenceLevel = 0;	//글레벨
		String getBn = request.getParameter("boardNumber");
		
		//답글
		if(getBn != null) {
			boardNumber = Integer.parseInt(getBn);
			groupNumber = Integer.parseInt(request.getParameter("groupNumber"));
			sequenceNumber = Integer.parseInt(request.getParameter("sequenceNumber"));
			sequenceLevel = Integer.parseInt(request.getParameter("sequenceLevel"));
		}
		
		request.setAttribute("boardNumber", boardNumber);
		request.setAttribute("groupNumber", groupNumber);
		request.setAttribute("sequenceNumber", sequenceNumber);
		request.setAttribute("sequencelevel", sequenceLevel);
		
		if(request.getParameter("pageNumber") != null) {
			request.setAttribute("pageNumber", request.getParameter("pageNumber"));
		}else {
			request.setAttribute("pageNumber", 1);
		}
		
		return "/WEB-INF/view/board/write.jsp";
	}

}
