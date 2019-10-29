<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
<link rel="stylesheet" href="${root}/css/guest/write.css" />
</head>
<body style="margin: 0 auto">
	<jsp:include page="../../../index.jsp"></jsp:include>
	<div align="center">
		<form action="#" method="get">
			<div class="title" style="text-align: left;">
				<label>이름</label> <input type="text" name="name" size="12" /> <label>비밀번호</label>
				<input type="password" name="pwd" size="12" />
			</div>
			<div class="content">
				<textarea cols="53" rows="5" name="message"></textarea>
			</div>

			<div class="title" style="text-align: right;">
				<input type="submit" value="확인"> 
				<input type="reset"value="취소">
			</div>
		</form>

	</div>
</body>
</html>