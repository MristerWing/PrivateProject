<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>Calendar</title>
<link rel="stylesheet" href="${root}/css/calendar/calendar.css" />
</head>
<body>
	<%-- <h3>${month} / ${days}</h3> --%>
	<c:set var="weekLessDay" value="${days%7}"></c:set>
	<fmt:parseNumber integerOnly="true" var="week" value="${days/7}"></fmt:parseNumber>
	<c:out value="${weekLessDay}"></c:out>
	<c:out value="${week}"></c:out>
	<c:set var="startDay" value="1"></c:set>
	<div class="mainContainer">
		<div class="calendar">
			<c:forEach begin="1" end="${week}" step="1">
				<ul class="weekBox">
					<c:forEach var="i" begin="${startDay}" end="7" step="1">
						<li class="dayBox">
							<div class="dayTitle">
								<label>week</label>
							</div>
							<div class="dayTitle">
								<label>day</label>
							</div>
							<div class="dayContent">
								<span>this is content</span>
							</div>
						</li>
					</c:forEach>
				</ul>
			</c:forEach>
		</div>
	</div>
</body>
</html>