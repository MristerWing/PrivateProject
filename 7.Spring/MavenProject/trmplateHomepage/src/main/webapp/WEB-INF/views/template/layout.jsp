<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${root}/css/common.css" />
<%-- <link rel="stylesheet" href="${root}/css/template.css" /> --%>
</head>
<body>
	<div class="template">
		<!-- header.jsp -->
		<t:insertAttribute name="header"></t:insertAttribute>
		<!-- menu.jsp -->
		<t:insertAttribute name="menu"></t:insertAttribute>
		<hr color="red" />

		<!-- content, 각각의 jsp -->
		<div class="content">
			<t:insertAttribute name="content"></t:insertAttribute>
			<hr color="blue" />
		</div>
		<div>
			<!-- footer.jsp -->
			<t:insertAttribute name="footer"></t:insertAttribute>
		</div>
	</div>
</body>
</html>