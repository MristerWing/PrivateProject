<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function test() {
		
		// 태그에 id를 부여한 뒤 그에 해당하는 id를 가진 태그를 가져온다.
		var app1 = document.getElementById("test1");
		var app2 = document.getElementById("test2");
		var span = app2.getElementsByTagName("span");
		
		app1.innerHTML = "태그1";
		span[0].innerHTML = "태그2";
		span[1].innerHTML = "태그2";
		span[2].innerHTML = "태그2";

	}

	// dom은 태그의 스타일이나 태그를 전부 변경이 가능하다.
	function abc() {
		var test3 = document.getElementById("test3");
		test3.innerHTML = "APPLE";
		test3.align = "left";
		test3.style.color = "red";
	}
</script>
</head>
<body onload="test()">
	<div id="test1"></div>

	<div id="test2">
		<span></span> 
		<span></span> 
		<span></span>
	</div>

	<div id="test3" align="center">사과</div>
	<input type="button" value="버튼" onclick="abc()" />
</body>
</html>