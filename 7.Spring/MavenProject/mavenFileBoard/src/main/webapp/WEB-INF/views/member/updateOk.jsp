<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정</title>
</head>
<body>
	<c:if test="${chk > 0}">
		<script type="text/javascript">
			alert("수정되었습니다.");
			location.href="${root}/member/main.do";
		</script>
	</c:if>
	
	<c:if test="${chk == 0}">
		<script type="text/javascript">
			alert("에러가 발생하여 수정에 실패하였습니다.");
			location.href="${root}/member/main.do";
		</script>
	</c:if>
</body>
</html>