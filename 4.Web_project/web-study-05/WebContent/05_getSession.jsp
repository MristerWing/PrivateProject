<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie &amp; Session</title>
</head>
<body>
	<%
		String id = (String) session.getAttribute("id");
		String pwd = (String) session.getAttribute("pwd");
		String age = (String) session.getAttribute("age");
	%>
	
	id : <%= id %><br>
	password : <%= pwd %><br>
	age : <%= age %><br>
</body>
</html>