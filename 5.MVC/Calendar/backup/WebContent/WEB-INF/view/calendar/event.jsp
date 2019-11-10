<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>event</title>
</head>
<body>
	<c:if test="${check > 0}">
		<script type="text/javascript">
			location.href="${root}/calendar/calendar.do"
		</script>
	</c:if>
	<c:if test="${check == 0}">
		<script type="text/javascript">
			location.href="${root}/consumer/errorPage.do";
		</script>
	</c:if>
</body>
</html>