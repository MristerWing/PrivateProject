<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<script type="text/javascript" src="${root}/resources/javascript/member/login.js"></script>
<link rel="stylesheet" href="${root}/resources/css/common.css" />
</head>
<body>
	<div align="center" style="margin: 0 auto;">
	<h3>정말로 탈퇴를 원하시면 아래에 비밀번호를 다시 입력하여 주세요.</h3>
		<form action="${root}/member/deleteOk.do" method="POST" onsubmit="return chkId(this)">
        <label>아이디 </label>
        <input type="text" name="id" value="${id}" disabled="disabled"/>
        <br><br>

        <label>비밀번호</label>
        <input type="password" name="pwd"/>
        <br><br>

        <input type="submit" value="전송"/>
        <input type="reset" value="취소"/>
        
        <br>
        <br>
        <a href="${root}/index.jsp">메인으로</a>
        
    </form>
	</div>
</body>
</html>