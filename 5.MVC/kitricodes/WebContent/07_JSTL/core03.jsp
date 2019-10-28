<%--지시자--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>import: 웹 어플리케이션 내부의 자원과 외부의 자원(HTTP, FTP)를 가져온다</h3>
	내부자원: <c:import url="core01.jsp"></c:import>
	<br>
	<br>
	<%--외부자원: <c:import url="https://www.naver.com"></c:import> --%>
	<%--외부자원은 파싱을 할때 사용한다.--%>
	외부자원: <c:import url="http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109"></c:import>
	
</body>
</html>