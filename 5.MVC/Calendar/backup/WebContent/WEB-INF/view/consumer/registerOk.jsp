<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="${root}/css/common.css" />
<link rel="stylesheet" href="${root}/css/consumer/registerC.css" />
</head>
<body>
	<c:if test="${check > 0}">
		<div class="wrap">
			<div class="mainContainer">
				<span class="welcome">환영합니다!</span>
				<div>
					<p class="content">가입이 완료되었습니다.</p>
					<p class="content">나만의 일정관리를 시작해 보세요!</p>
				</div>
				<div style="text-align: right;">
					<a href="${root}/calendar/calendar.do" class="link">바로가기</a>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${check == 0}">
		<script type="text/javascript">
			location.href="${root}/consumer/errorPage.do";
		</script>
	</c:if>
</body>
</html>