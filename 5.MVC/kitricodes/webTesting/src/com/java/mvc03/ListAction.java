package com.java.mvc03;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListAction {
	public String proRequest(HttpServletRequest request, HttpServletResponse response) {
		//request객체를 이용해서 DB를 호출(DAO, DTO)
		request.setAttribute("listMsg", "this is list page");
		return "/09_MVC/list.jsp";
	}
}
