<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="javascript/02_Class.js"></script>
<script type="text/javascript" src="javascript/02_function.js"></script>
</head>
<body>
	<label>수</label>
	<input type="text" name="number" id="number" />
	<br>
	<br>
	<label>부호</label>
	<input type="text" name="oper" id="oper" />
	<br>
	<br>
	<label>수</label>
	<input type="text" name="value" id="value" />
	<br>
	<br>
	
	<input type="button" value="전송" onclick="result()" />
	<input type="reset" value="취소" />
	
	<span>결과</span>
	<span id="result"></span>
</body>
</html>