package com.java.mvc03;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteAction { 
	public String proRequest(HttpServletRequest request, HttpServletResponse response) {
		//request객체를 이용해서 DB를 호출(DAO, DTO)
		request.setAttribute("writeMsg", "this is write page");
		return "/09_MVC/write.jsp";
	}
}
