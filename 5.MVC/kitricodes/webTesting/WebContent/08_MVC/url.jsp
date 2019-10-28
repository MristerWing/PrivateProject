<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC01</title>
</head>
<body>
	<h3>URL Pattern 디렉토리 패턴 방식</h3>
	<div>
		디렉토리 형태로 해당 컴포넌트를 찾아서 실행하는 구조
		보안에 취약, 한곳에 처리를 한다. 즉 요청하는 서블릿 파일을 전부 만들어야 함.
		현재는 사용안함
	</div>
	
	<br>
	<br>
	
	<!--
	<a href="http://localhost:8181/webTesting/com/java/mvc02/ABC">서버요청 - com/java/mvc02/ABC</a>
	<br>
	<br>
	-->
	<!--
	<a href="http://localhost:8181/webTesting/aa/b/not/ABC">서버요청 - 무작위</a>
	<br>
	<br>
	-->
	<!--
	<a href="http://localhost:8181/webTesting/BBC">서버요청 - BBC</a>
	<br>
	<br>
	-->
	
	<h3>확장자 패턴</h3>
	<div>
		확장자 형태의 서버의 해당 컴포넌트를 찾아서 실행하는 구조
	</div>
	
	<a href="http://localhost:8181/webTesting/mogila/what/a/KBS.sbs">서버요청 - /mogila/what/a/KBS.sbs</a>
	<br>
	<br>
	<a href="http://localhost:8181/webTesting/hello.sbs">서버요청 - /mogila/what/a/KBS.sbs</a>
	
	<h3>글쓰기 / 글읽기</h3>
	<a href="http://localhost:8181/webTesting/write.kitri" style="margin-right: 10px;">
		글쓰기
	</a>
	<a href="http://localhost:8181/webTesting/read.kitri">
		글읽기
	</a>
	
</body>
</html>