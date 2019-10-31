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
		int sequencelevel = 0;	//글레벨
		String getGn = request.getParameter("gruopNumber");
		
		//답글
		if(getGn != null) {
			boardNumber = Integer.parseInt(getGn);
		}
		
		request.setAttribute("boardNumber", boardNumber);
		request.setAttribute("groupNumber", groupNumber);
		request.setAttribute("sequenceNumber", sequenceNumber);
		request.setAttribute("sequencelevel", sequencelevel);
		
		return "/WEB-INF/view/board/write.jsp";
	}

}
