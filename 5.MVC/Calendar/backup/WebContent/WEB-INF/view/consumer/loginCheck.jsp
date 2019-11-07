<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<c:if test="${ID != null}">
		<c:set var="ID" value="${ID}" scope="session"/>
	
		<script type="text/javascript">
			location.href="${root}/index.jsp"
		</script>
	</c:if>
	<c:if test="${ID == null}">
		<script type="text/javascript">
			location.href="${root}/consumer/errorPage.do";
		</script>
	</c:if>
</body>
</html>