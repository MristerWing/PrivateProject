<%@page import="java.util.StringTokenizer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Exam</title>
</head>
<body>
	<h3>for 문</h3>
	<%--items: arrayList출력시 사용 --%>
	<c:forEach var="i" begin="1" end="10" step="2">
		<c:out value="${i}"></c:out>
	</c:forEach>

	<br>
	<br>

	<%--step생략하면 작동안함. 증가값임--%>
	<c:forEach var="j" begin="1" end="10" step="1">
		<c:if test="${j%2==0}">
			<c:out value="${j}"></c:out>
		</c:if>
	</c:forEach>

	<%--
		ArrayList<String> arrList = new ArrayList<String>(); 
		arrList.add("사과");
		.
		.
		.
		.
		.
		.
		.
		.
		for(int i = 0;i < arrList.size();i++) {
			System.out.println(arrList.get(i));
		} 	
	--%>

	<%--
		ArrayList<String> arrList = new ArrayList<String>();
	
		arrList.add("hello1");		
		arrList.add("hello2");		
		arrList.add("hello3");		
		arrList.add("hello4");		
	--%>

	<%--	
		<c:forEach var="str" items="${arrList}">
			<c:out value="${str}"/>
		</c:forEach>
	 --%>

	<h3>for Tokens</h3>
	<c:set var="city" value="서울,부산,대구,광주"></c:set>
	
	<c:forTokens var="data" items="${city}" delims=",">
		<c:out value="${data}"/>
	</c:forTokens>
	
	<br>
	<br>
	
	<%--Java StringTokenizer--%>
	<%
		StringTokenizer st = new StringTokenizer("this is a test");
		while (st.hasMoreTokens()) {
			//System.out.println(st.nextToken());
			String str = st.nextToken();
			%>
			<span><%=str%></span>
			<br>
			<br>
			<%
		}
	%>
	
	<br>
	<br>

	<%--forTokens는 다른종류의 여러가지 구분자를 구성하여 잘라낼 수 있다.--%>
	<c:set var="traffic" value="비행기, 자동차, 승합차| 자전거. 오토바이"/>
	<c:forTokens var="data" items="${traffic}" delims=",|.">
		<c:out value="${data}"></c:out>
	</c:forTokens>

</body>
</html>