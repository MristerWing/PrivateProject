<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>${id}님, 환영합니다!</title>
</head>
<body>
	<c:if test="${memberLevel != null}">
		<script type="text/javascript">
			alert("로그인 완료");
		</script>
	</c:if>
	<c:if test="${memberLevel == null}">
		<script type="text/javascript">
			alert("로그인 실패. 회원가입을 해주세요.");
			location.href="${root}/member/register.do";
		</script>
	</c:if>
</body>
</html>