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
	// 1. Cookie 객체 생성
	Cookie cookie = new Cookie("id", "KJS");
	// 2. 유효기간 설정
	cookie.setMaxAge(365 * 24 * 60 * 60);
	// 3. 클라이언트에 쿠키 전송
	response.addCookie(cookie);
	// 4. 쿠키를 생성하여 클라이언트에 전송
	response.addCookie(new Cookie("pwd", "test1234"));
	response.addCookie(new Cookie("age", "26"));
%>

<h3>쿠키 설정</h3>

</body>
</html>