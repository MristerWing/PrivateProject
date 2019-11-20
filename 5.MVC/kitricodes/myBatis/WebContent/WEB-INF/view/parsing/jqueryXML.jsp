<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${root}/css/common.css" />
<script type="text/javascript" src="${root}/xhr/jquery-3.4.1.js"></script>
<script type="text/javascript" >
$(() => {
	console.log("${a}");
    $.ajax({
        url: "${root}/pXML.do",
        type: "get",
        dataType: "xml",
        success: data => {
            var location = $(data)
                .children()
                .find("location");

            $(location).each((i, e) => {
                var city = $(e)
                    .find("city")
                    .text();

                var wf = $($(e).find("wf")[0]).text();

                $("#disp").append("<p>" + city + "</p>");
                $("#disp").append("<p>" + wf + "</p>");
            });
        }
    });
});
</script>
</head>
<body>
	<div id="disp"></div>
	<script type="text/javascript" src="${root}/javascript/parsing/jqueryParsing.js"></script>
</body>
</html>