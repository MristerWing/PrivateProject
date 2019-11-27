<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${root}/css/common.css" />
</head>
<body>
	<h3>게시판</h3>
	<a href="${root}/board/write.do">글쓰기</a>
	<a href="${root}/board/list.do">글목록</a>
	<h3>한줄 댓글</h3>
	<a href="${root}/reply/list.do">한줄댓글가기</a>
</body>
</html>