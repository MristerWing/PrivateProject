package com.java.mvc05;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListAction implements CommandAction {

	@Override
	public String preRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setAttribute("listMsg", "list");
		return "/09_MVC/list.jsp";
	}

}
