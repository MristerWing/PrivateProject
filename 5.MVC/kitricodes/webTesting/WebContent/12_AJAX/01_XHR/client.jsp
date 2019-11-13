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
	<!-- 요청시 서버(내부, 외부) 데이터 전송(Text(JSON), XML) -->
	<h3>비동기 통신</h3>
	<form action="#"> <!-- action: 내 외부 서버 URL -->
		<input type="button" value="요청" onclick="startRequest()" />
	</form>
	<br>
	<br>
	
	<div id="resultDisp"></div>
</body>
</html>