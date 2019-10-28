package com.java.mvc04;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteAction implements CommandAction {
	@Override
	public String preRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setAttribute("writeMsg", "write");
		return "/09_MVC/write.jsp";
	}
}
