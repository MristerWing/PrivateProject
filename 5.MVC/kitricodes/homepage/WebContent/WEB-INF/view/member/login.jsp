<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript" src="${root}/javascript/member/login.js"></script>
</head>
<body>
	<div align="center" style="margin: 0 auto;">
		<form action="${root}/member/loginOk.do" method="POST" onsubmit="return chkId(this)">
        <label>아이디 </label>
        <input type="text" name="id"/>
        <br><br>

        <label>비밀번호</label>
        <input type="password" name="pwd"/>
        <br><br>

        <input type="submit" value="전송"/>
        <input type="reset" value="취소"/>
    </form>
	</div>
</body>
</html>