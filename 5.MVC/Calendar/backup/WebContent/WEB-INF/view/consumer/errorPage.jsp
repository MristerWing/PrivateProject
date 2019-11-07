<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>ERROR</title>
<link rel="stylesheet" href="${root}/css/common.css" />
<link rel="stylesheet" href="${root}/css/consumer/registerC.css" />
</head>
<body>
	<div class="wrap">
		<div class="mainContainer">
			<span class="welcome">죄송합니다...</span>
			<div>
				<p class="content">에러가 발생하였습니다.</p>
				<p class="content">잠시후 다시 시도하여 주세요..</p>
			</div>
			<div style="text-align: right;">
				<a href="${root}/index.jsp" class="link">돌아가기</a>
			</div>
		</div>
	</div>
</body>
</html>