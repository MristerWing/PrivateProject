<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--주석, %@: 페이지 지시어--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java(JSP) Standard Tag Library</title>
</head>
<body>
	<h3>출력</h3>
	<div>
		<c:out value="JSTL연습" />
		<br>
		<c:out value="10" />
		<br>
	</div>

	<h3>변수 선언</h3>
	<div>
		<%--page는 생략 가능 request, session, application --%>
		<c:set var="str" value="HelloWorld!" scope="page" />
		<c:set var="su" value="10"></c:set>
		
		<%--JSTL의 비교 연산자는 문자열 처리 --%>
		<c:set var="isbig" value="10 > 9"></c:set>
		
		<%--This is EL(Expression Language)! --%>
		<c:out value="${str}"></c:out><br>
		<c:out value="${su}"></c:out><br>
		<c:out value="${su*30}"></c:out><br>
		<c:out value="${su}"></c:out><br>
		<c:out value="${su >= 10}"></c:out><br>
		<c:out value="${isbig}"></c:out><br>
	</div>

	<%--EL은 출력기능이 있다.--%>
	<h3>${str}, ${su}</h3>

	<h3>변수 제거</h3>
	<c:remove var="str"/>
	<%--EL은 null error를 발생시키지 않는다.--%>
	is a <c:out value="${str}"></c:out>
	<br>
	<br>
	
	<h3>if</h3>
	<c:set var="fruit" value="apple"></c:set>
	<c:if test="${fruit == 'apple'}">
		<c:out value="사과임"></c:out>
	</c:if>
	
	<c:if test="${fruit != 'apple'}">
		<c:out value="사과아님"></c:out>
	</c:if>
	
	<%--set을 이용하여 동일명의 변수를 재정의가 가능--%>
	<c:set var="fruit" value="orange"></c:set>
	
	<h3>if ~ else if</h3>
	<c:choose>
		<c:when test="${fruit == 'apple'}">
			${'사과임'}
		</c:when>
		<c:when test="${fruit == 'banana'}">
			${'바나나임'}
		</c:when>
		<c:when test="${fruit == 'orange'}">
			${'오렌지임'}
		</c:when>
		
		<%--else--%>
		<c:otherwise>
			${'뭔지모름'}
		</c:otherwise>
	</c:choose>

</body>
</html>