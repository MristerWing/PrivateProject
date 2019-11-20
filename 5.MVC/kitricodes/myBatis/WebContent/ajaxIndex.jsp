<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>FirstPage</title>
<link rel="stylesheet" href="${root}/css/common.css" />
</head>
<body>
	<%-- <a href="${root}/sawon/list.do">사원리스트</a> --%>

	<h3>댓글</h3>
	<a href="${root}/reply/replyList.do">실시간 댓글 달기</a>
	
	<h3>JSON</h3>
	<a href="${root}/json.do?msg=obj">JSON - Object</a> 
	<br>
	<br>
	<a href="${root}/json.do?msg=array">JSON - Array</a>
	<br>
	<br>
	<a href="${root}/json.do?msg=objectarray">JSON - ObjectArray</a>
	
	<h3>Parsing</h3>
	<a href="${root}/parsing.do">기상청</a>
	
</body>
</html>