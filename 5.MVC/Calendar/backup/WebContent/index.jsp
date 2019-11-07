<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>Main page</title>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap" rel="stylesheet">
<link rel="stylesheet" href="${root}/css/common.css" />
</head>
<body>
	<c:if test="${ID != null}">
		<h3>${ID}님, 환영합니다!</h3>
		<a href="${root}/consumer/logout.do">go to logout</a>
		<a href="${root}/consumer/checkPassword.do?goingURL=update">go to update</a>
		<a href="${root}/consumer/checkPassword.do?goingURL=delete">go to delete</a>
	</c:if>
	<c:if test="${ID == null}">
		<a href="${root}/consumer/login.do">go to login</a>
		<a href="${root}/consumer/register.do">go to register</a>
	</c:if>
	<a href="${root}/calendar/calendar.do">go to calendar</a>
	
</body>
</html>