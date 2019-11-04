package com.java.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.member.dao.MemberDao;

/**
 * @개발자 KJS
 * @작성일 2019. 10. 28.
 * @설명 
 */

public class IdCheckAction implements CommandAction {
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String id = request.getParameter("id");
		logger.info(logMsg + id);
		
		int chk = MemberDao.getInstance().idCheck(id);
		logger.info(logMsg + chk);
		
		request.setAttribute("chk", chk);
		request.setAttribute("id", id);
		
		return "/WEB-INF/view/member/idCheck.jsp";
	}
	
}
