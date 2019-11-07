package com.gmx0807.consumer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmx0807.command.CommandAction;

public class CheckPasswordAction implements CommandAction {

	@Override
	public String propertiesRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String goingURL = request.getParameter("goingURL");
		request.setAttribute("goingURL", goingURL);
		
		return "/WEB-INF/view/consumer/checkPassword.jsp";
	}

}
