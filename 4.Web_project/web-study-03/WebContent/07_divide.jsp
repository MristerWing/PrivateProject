<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- JSP페이지에서 에라가 발생하였을 때 보여줄 에러 페이지로 error.jsp를 설정  -->
<%@ page errorPage = "error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
0 divide is impossible
<!-- 강제로 에러 발생 -->
<%= 2/0 %>
</body>
</html>