<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 확인</title>
<link rel="stylesheet" href="${root}/css/common.css" />
<link rel="stylesheet" href="${root}/css/consumer/login.css" />
</head>
<body>
	<div class="wrap">
		<div class="mainContainer">
			<div class="logo">
				<span class="logoContent">Calendar</span>
			</div>
			<form action="${root}/consumer/${goingURL}.do" method="post">
				<h3>사용자 확인을 위해 비밀번호를 다시 입력해 주세요.</h3>
				<ul class="loginBox">
					<li class="lineText"><input type="password" name="password" /></li>
					<li><input class="loginButton" type="submit" value="확인" /></li>
				</ul>
			</form>
		</div>
	</div>
</body>
</html>