<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function test() {
		
		// 하나의 기준점을 잡으면, 그 하위에 해당하는 태그를 가져올 수 있다. 폰트의 자식으로 잡혀있는 span을 가져왔다. 
		var font = document.getElementsByTagName("font");
		var span = font[0].getElementsByTagName("span");
		span[0].innerHTML = "HELLO";
		span[1].innerHTML = "WORLD!";
	}
</script>
</head>
<body>
	<font> 
		<span></span><br> 
		<span></span><br> <input
		type="button" value="클릭" onclick="test()" />
	</font>
</body>
</html>