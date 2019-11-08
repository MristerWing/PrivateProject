<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="javascript/DOM04.js"></script>
</head>
<body>
	<div id="text"></div>
	<br>
	<br>

	<form id="myForm">
		<input type="radio" name="select" value="Koala" onchange="sub()" />
		<label>코알라</label>
		
		<input type="radio" name="select" value="Jellyfish" onchange="sub()" />
		<label>해파리</label>
		
		<input type="radio" name="select" value="Penguins" onchange="sub()" />
		<label>팽귄</label>
		
		<input type="radio" name="select" value="Tulips" onchange="sub()" />
		<label>튤립</label>
		
		<input type="radio" name="select" value="배" onchange="sub()" />
		<label>암것도안나옴</label>
		
		<br>
		<br>
		<div id="msg"></div>
	</form>
</body>
</html>