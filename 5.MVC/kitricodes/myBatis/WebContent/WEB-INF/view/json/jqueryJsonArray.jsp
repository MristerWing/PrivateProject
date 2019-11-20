<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>JSON - Array</title>
<link rel="stylesheet" href="${root}/css/common.css" />
<script type="text/javascript" src="${root}/xhr/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${root}/javascript/jqueryJson/array.js"></script>
</head>
<body onload="toServer('${root}')">
	<div id="disp"></div>
</body>
</html>