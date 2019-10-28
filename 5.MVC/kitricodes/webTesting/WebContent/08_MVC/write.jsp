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
	<h3>Write!</h3>
	<c:out value="${check}"/>
	
	<c:if test="${check > 0 }">
		<script type="text/javascript">
			alert('글 작성이 되었습니다.');
		</script>
	</c:if>
	
	<c:if test="${check == 0 }">
		<script type="text/javascript">
			alert('글 작성을 실패하였습니다.');
		</script>
	</c:if>
</body>
</html>