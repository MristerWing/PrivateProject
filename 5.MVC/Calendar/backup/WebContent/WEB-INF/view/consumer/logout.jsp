<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
</head>
<body>
	<c:remove var="ID" scope="session" />
	<script type="text/javascript">
		location.href = "${root}/consumer/login.do";
	</script>
</body>
</html>