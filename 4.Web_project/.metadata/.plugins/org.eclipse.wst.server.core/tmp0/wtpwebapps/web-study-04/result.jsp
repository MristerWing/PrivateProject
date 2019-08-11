<%@ page import = "java.net.URLDecoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<%
String result = "";
int sum = 0;
int num = Integer.parseInt(request.getParameter("number"));
for(int i = 1;i <= num;i++) {
	sum += i;
	System.out.println(sum);
	if(i == num) {
		 result += (" = " + sum);
	}
	else if(i == 1) {
		result += ("" + i);
	}
	else result  += (" + " + i);
}
%>
<h1>1부터 <%=request.getParameter("number") %>까지 자연수 합 구하기</h1>
<%=result %>
</body>
</html>