package com.java.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.command.CommandAction;
import com.java.member.dao.MemberDao;

/**
 * @개발자 KJS
 * @작성일 2019. 10. 29.
 * @설명 
 */

public class DeleteOkAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("id");
		String password = request.getParameter("pwd");
		
		logger.info(logMsg + id + "\t" + password);
		
		int chk = MemberDao.getInstance().deleteOk(id, password);
		logger.info(logMsg + chk);
		
		request.setAttribute("chk", chk);
		
		return "/WEB-INF/view/member/deleteOk.jsp";
	}

}
