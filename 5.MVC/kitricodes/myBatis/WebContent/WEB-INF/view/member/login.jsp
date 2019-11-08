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
<link rel="stylesheet" href="${root}/css/common.css" />
<link rel="stylesheet" href="${root}/css/member/login.css" />
</head>
<body>
	<div align="center">
		<div class="loginBox">
			<form action="${root}/member/loginOk.do" method="POST" onsubmit="return chkId(this)">
        		<label>아이디 </label>
        		<input type="text" name="id"/>
        		<br><br>

      	  		<label>비밀번호</label>
	        	<input type="password" name="pwd"/>
	        	<br><br>

       	 		<input type="submit" value="전송"/>
       	 		<input type="reset" value="취소"/>
        
        		<br>
        		<br>
    		</form>	
		</div>
		<a href="${root}/index.jsp">메인으로</a>
	</div>
</body>
</html>