package com.gmx0807.consumer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmx0807.command.CommandAction;

public class LogoutAction implements CommandAction {

	@Override
	public String propertiesRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		return "/WEB-INF/view/consumer/logout.jsp";
	}

}
