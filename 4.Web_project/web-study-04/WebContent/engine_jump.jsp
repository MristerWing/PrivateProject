<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String engine = request.getParameter("engine");

	switch (engine) {
	case "naver":
		response.sendRedirect("https://www.naver.com");
		break;
	case "daum":
		response.sendRedirect("https://www.daum.net");
		break;
	case "nate":
		response.sendRedirect("https://www.nate.com");
		break;
	case "google":
		response.sendRedirect("https://www.google.com");
		break;
	}
%>