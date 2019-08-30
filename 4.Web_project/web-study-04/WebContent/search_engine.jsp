<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>검색 엔진 정보 페이지</h1>
	<h3>검색 엔진을 선택하세요.</h3>
	<form method="get" action="engine_jump.jsp">
		<span style="float: left; margin-right: 20px"> <label
			for="engine">검색엔진</label> <select id="engine" name="engine" size="1">
				<option value="naver">네이버</option>
				<option value="daum">다음</option>
				<option value="nate">네이트</option>
				<option value="google">구글</option>
		</select>
		</span>
		<input type = "submit" value = "확인">
	</form>
</body>
</html>