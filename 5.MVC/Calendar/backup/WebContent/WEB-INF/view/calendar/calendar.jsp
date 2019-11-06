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
<!-- <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script> -->
<script type="text/javascript"
	src="${root}/javascript/calendar/moment-with-locales.js"></script>
<script type="text/javascript"
	src="${root}/javascript/calendar/calendar.js"></script>
</head>
<body>
	<c:set var="weeks" value="5" />
	<%-- <c:out value="${weekLessDay}"></c:out>
	<c:out value="${everyWeek}"></c:out>
	<c:out value="${lastMonthDays}"></c:out> --%>
	<c:set var="startDay" value="0"></c:set>
	<c:set var="startDate" value="1"></c:set>
	<div class="header">
		<a href="#">회원수정</a> <a href="#">로그아웃</a>
	</div>
	<div class="mainContainer">
		<div class="infoBlock">
			<div class="infoBlockSub info">
				<label>info</label>
			</div>

			<div class="infoBlockSub edit">
				<label>edit</label>
			</div>
		</div>
		<div class="calendar">
			<div class="calendarTitle">
				<label id="calendarTitleID"></label>
				<script type="text/javascript">printCalendarTitle('${month}')</script>
			</div>
			<c:forEach begin="1" end="${weeks}" step="1">
				<ul class="weekBox">
					<c:forEach var="day" begin="${startDay}" end="${startDay + 6}"
						step="1">
						<c:set var="daysID" value="day${day}"></c:set>
						<li class="dayBox" role="button"
							onclick="javascript:console.log(${day})">
							<div class="dayTitle">
								<label id="${daysID}">day</label>
								<script type="text/javascript">printDayTitle2('${day}', '${daysID}')</script>
							</div>
							<div class="dayTitle">
								<label> <c:if test="${isSunday == false}">
										<c:if test="${lastMontStartDay > lastDays}">
											${startDate}
											<c:set var="startDate"
												value="${startDate < days?startDate + 1:startDate}"></c:set>
										</c:if>
										<c:if test="${lastMontStartDay <= lastDays}">
											${lastMontStartDay}
											<c:set var="lastMontStartDay" value="${lastMontStartDay + 1}"></c:set>
										</c:if>
									</c:if>
									<c:if test="${isSunday == true}">
										<c:if test="${startDate > days}">
											<c:set var="startDate" value="1"></c:set>
										</c:if>
										<c:if test="${startDate <= days}">
											${startDate}
											<c:set var="startDate"
												value="${startDate + 1}"></c:set>
										</c:if>
									</c:if>
								</label>
							</div>
							<div class="dayContent">
								<span>this is content</span>
							</div>
						</li>
					</c:forEach>
					<c:set var="startDay" value="${startDay + 7}"></c:set>
				</ul>
			</c:forEach>
		</div>
	</div>
</body>
</html>