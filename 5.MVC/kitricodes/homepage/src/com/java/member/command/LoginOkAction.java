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

public class LoginOkAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		logger.info(logMsg + id + " " + pwd);
		
		String memberLevel = MemberDao.getInstance().login(id, pwd);
		logger.info(logMsg + memberLevel);
		
		/*
		 * request.setAttribute("id", id); request.setAttribute("pwd", pwd);
		 */
		
		if(memberLevel != null) {
			request.setAttribute("memberLevel", memberLevel);
			request.setAttribute("id", id);
		}
		
		return "/WEB-INF/view/member/loginOk.jsp";
	}

}
