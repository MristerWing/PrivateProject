package com.java.member.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;

/**
 * @개발자 KJS
 * @작성일 2019. 10. 27.
 * @설명 
 */

public class RegisterAction implements CommandAction {
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		logger.info(logMsg + request.getContextPath());
		
		/*
		 * response.setContentType("application/txt;charset=UTF-8"); PrintWriter out =
		 * response.getWriter(); out.print(request.getContextPath()); out.close();
		 */
		
		return "/WEB-INF/view/member/register.jsp";
	}
}
