<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력화면</title>
</head>
<body>
<form method = "post" action = "04_testLogin.jsp">
	<label for = "uesrid"> 아이디: </label>
	<input type = "text" name = "id" id = "uesrid"> <br>
	
	<label for = "uesrpwd"> 암 &nbsp; 호: </label>
	<input type = "password" name = "pwd" id = "uesrpwd"> <br>
	
	<input type = "submit" value = "로그인">
</form>
</body>
</html>