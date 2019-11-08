<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div align="center">
		<br> <br>
		<c:if test="${viewPage != null}">
			<jsp:include page="${viewPage}"></jsp:include>
		</c:if>
	</div>
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>