<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FMT02 - DATE</title>
</head>
<body>

	<h3>날짜를 문자로 변환(format to String)</h3>
	
	<%--JSTL객체선언 --%>
	<jsp:useBean id="date" class="java.util.Date"></jsp:useBean>
	<c:set var="date" value="${date}"></c:set>
	<c:out value="${date}"></c:out>
	<br>

	<%-- <jsp:useBean id="cal" class="java.util.cal"></jsp:useBean>
	<c:set var="date" value="${date}"></c:set>
	<c:out value="${date}"></c:out> --%>
	
	<fmt:formatDate value="${date}" type="date"/>
	<br>
	<fmt:formatDate value="${date}" type="time"/>
	<br>
	<fmt:formatDate value="${date}" type="both"/>
	<br>
	<fmt:formatDate value="${date}" pattern="yyyy/MM/dd HH:mm:ss"/>
	<br>
	
		
	<h3>문자를 날짜로 변환(String to format)</h3>
	<c:set var="my" value="1980-12-25 00:00:10"></c:set>
	<c:out value="origin: ${my}"></c:out>
	<br>
	
	<fmt:parseDate var="pMy" value="${my}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate>
	<c:out value="${pMy }"></c:out>
	<br>
	<fmt:formatDate value="${pMy}" type="date"/>
	
</body>
</html>