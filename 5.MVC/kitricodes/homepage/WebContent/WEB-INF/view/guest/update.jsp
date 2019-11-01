<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
<link rel="stylesheet" href="${root}/css/common.css" />
<link rel="stylesheet" href="${root}/css/guest/write.css" />
<script type="text/javascript" src="${root}/javascript/guest/update.js"></script>
</head>
<body>
	<div align="center">
		<form class="form update" action="${root}/guest/updateOk.do" method="get" onsubmit="return check(this, '${guestDto.password}')">
			<input type="hidden" name="num" value="${guestDto.num}"/>
			<input type="hidden" name="pageNumber" value="${pageNumber}"/>
			<div class="title" style="text-align: left;">
				<c:out value="${guestDto.num}"></c:out>
				<label>이름</label> <input type="text" name="name" size="12" value="${guestDto.name}" disabled="disabled" /> 
				<label>비밀번호</label>
				<%--value="${guestDto.password}" --%>
				<input type="password" name="pwd" size="12" />
			</div>
			<div class="content">
				<textarea cols="53" rows="5" name="message">${guestDto.message}</textarea>
			</div>

			<div class="title" style="text-align: right;">
				<input type="submit" value="확인"> <input type="reset"
					value="취소">
			</div>
		</form>
	</div>
</body>
</html>