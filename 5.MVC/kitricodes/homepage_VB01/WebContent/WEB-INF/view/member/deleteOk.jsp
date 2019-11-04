<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
</head>
<body>
	<c:if test="${chk > 0}">
		<c:remove var="id" scope="session"/>
		<c:remove var="memberLevel" scope="session"/>
		<script type="text/javascript">
			alert("탈퇴가 완료되었습니다.");
			location.href="${root}/index.jsp";
		</script>
	</c:if>
	
	<c:if test="${chk == 0}">
		<script type="text/javascript">
			alert("에러가 발생하여 탈퇴에 실패하였습니다.");
			location.href="${root}/index.jsp";
		</script>
	</c:if>
</body>
</html>