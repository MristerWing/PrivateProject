<%@page import="sun.java2d.pipe.SpanShapeRenderer.Simple"%>
<%@page import = "java.text.SimpleDateFormat" %>
<%@page import = "java.util.Calendar" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Calendar date = Calendar.getInstance();
SimpleDateFormat today = new SimpleDateFormat("yyyy/MM/dd");
SimpleDateFormat now = new SimpleDateFormat("hh:mm:ss");
%>
Today's <b> <%= today.format(date.getTime()) %></b> <br>
Time is <b> <%= now.format(date.getTime()) %></b> 
</body>
</html>