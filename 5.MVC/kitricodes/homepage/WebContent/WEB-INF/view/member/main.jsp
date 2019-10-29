<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>${id}님 환영합니다.</title>
</head>
<body>
	<jsp:include page="../../../index.jsp"/>
	<br>
	<br>
	<h3>${id}님 환영합니다.</h3>
	<a href="${root}/index.jsp">메인으로</a>
</body>
</html>