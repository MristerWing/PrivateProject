<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="javascript/01_Class.js"></script>
<script type="text/javascript">
	function instanceFruit() {
		var fruit = new Fruit();

		fruit.taste();
		fruit.disp("hi");

		var clone = fruit.clone;

		console.log(typeof fruit, typeof clone);
	}
	
	function instanceApple() {
		var apple = new Apple();
		apple.taste();
		apple.abc();
	}
	
	function instanceOrange() {
		var orange = new Orange();
		orange.taste();
	}
</script>
</head>
<body>
	<label>과일</label>
	<input type="button" value="과일" onclick="instanceFruit()" />
	<br>
	<br>
	<label>사과</label>
	<input type="button" value="사과" onclick="instanceApple()" />
	<br>
	<br>
	<label>오렌지</label>
	<input type="button" value="오렌지" onclick="instanceOrange()" />
	<br>
	<br>
</body>
</html>