package com.java.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;

/**
 * @개발자 KJS
 * @작성일 2019. 10. 28.
 * @설명 
 */

public class LogoutAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		return "/WEB-INF/view/member/logout.jsp";
	}

}
