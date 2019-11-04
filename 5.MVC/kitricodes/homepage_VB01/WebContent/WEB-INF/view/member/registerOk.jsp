<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 확인 결과</title>
</head>
<body>
	<c:if test="${chk > 0}">
	<script type="text/javascript">
		alert("회원가입 완료.");
		location.href="${root}/index.jsp";
	</script>
	</c:if>
	
	<c:if test="${chk == 0}">
	<script type="text/javascript">
		alert("에러가 발생하여 회원가입에 실패하였습니다.");
		location.href="${root}/index.jsp";
	</script>
	</c:if>
	
</body>
</html>