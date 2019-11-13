<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Asynchronous Javascript And XML</title>
<script type="text/javascript" src="../xhr.js"></script>
<script type="text/javascript" src="function.js"></script>
</head>
<body>
	<h3>POST / GET</h3>
	<form action="">
		<input type="text" name="msg" id="msg" />
		<input type="button" value="입력" onclick="toServer()" />
	</form>
	<br>
	<br>
	
	<h3 id="disp"></h3>
</body>
</html>