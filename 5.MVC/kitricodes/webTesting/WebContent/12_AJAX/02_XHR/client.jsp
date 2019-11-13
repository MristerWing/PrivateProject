<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Asynchronous Javascript And XML</title>
<script type="text/javascript" src="xhr.js"></script>
</head>
<body>
	<form action="#" id="createForm">
		<label>아이디</label>
		<input type="text" name="id" />
		<br>
		<br>

		<label>비밀번호</label>
		<input type="password" name="password" />
		<br>
		<br>
		
		<input type="button" value="전송" onclick="startRequest()" />		
	</form>
	
	<div id="resultDisp"></div>
</body>
</html>