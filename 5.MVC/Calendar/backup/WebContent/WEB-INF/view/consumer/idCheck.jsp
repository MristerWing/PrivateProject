<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>id확인</title>
<link rel="stylesheet" href="${root}/css/common.css" />
<link rel="stylesheet" href="${root}/css/consumer/register.css" />
</head>
<body>
	<c:if test="${check > 0}">
		<div align="center">
			이미 사용중인 아이디 입니다.
			<form action="${root}/consumer/idCheck.do" method="post">
				<input type="text" name="ID" /> <input class="checkIdButton"
					style="margin: 0;" type="submit" value="확인" />
			</form>
		</div>
	</c:if>

	<c:if test="${check == 0}">
		<div align="center">사용가능한 아이디입니다.</div>
	</c:if>

	<script type="text/javascript">
		opener.form.ID.value = "${ID}";
		opener.form.isCheckedID.value = "check";
	</script>

	<div align="center">
		<a href="javascript:self.close()" class="checkIdButton">닫기</a>
	</div>
</body>
</html>