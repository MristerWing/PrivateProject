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
	<h3>응답 내용</h3>
	<form action="#">
		<input type="button" id="sendRet" value="정보요청"
			onclick="startRequest()" />
	</form>
	<br>
	<br>

	<div id="divResult"></div>
</body>
</html>