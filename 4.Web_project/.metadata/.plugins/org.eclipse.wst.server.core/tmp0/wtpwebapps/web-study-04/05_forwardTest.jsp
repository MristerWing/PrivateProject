<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int age = Integer.parseInt(request.getParameter("age"));
if(age <= 19) {
	%>
	<script type = "text/javascript">
		alert("19세 미만이므로 입장 불가능")
		/*history객체 속성: lenth, back(), forward(), go()*/
		history.go(-1) //history.back()와 동일
	</script>
	<%
}else {
	request.setAttribute("name", "김진수");
	RequestDispatcher dispatcher = request.getRequestDispatcher("05_forwardResult.jsp");
	dispatcher.forward(request, response);
}
%>