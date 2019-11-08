<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOM01</title>
<script type="text/javascript">
	var div = document.getElementsByTagName("div"); //태그의 이름에 해당하는 값을 가져온다. 문서의 div태그를 가져옴
	
	// 가져온 태그는 배열값으로 가져와진다. 배열을 순환하여 값을 변경
	div[0].innerHTML = "this is div1";
	div[1].innerHTML = "this is div2";
</script>
</head>
<body>
	<div></div>
	<div></div>

	<input type="button" value="클릭" onclick="test()" />
</body>
</html>