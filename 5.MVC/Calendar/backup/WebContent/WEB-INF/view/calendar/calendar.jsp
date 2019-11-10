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
<link rel="stylesheet" href="${root}/css/common.css" />
<link rel="stylesheet" href="${root}/css/calendar/calendar.css" />
<!-- <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script> -->
<script type="text/javascript"
	src="${root}/javascript/calendar/moment-with-locales.js"></script>
<script type="text/javascript"
	src="${root}/javascript/calendar/calendar.js"></script>
</head>
<body>
	<c:if test="${ID == null}">
		<script type="text/javascript">
			location.href = "${root}/consumer/login.do";
		</script>
	</c:if>

	<c:if test="${ID != null}">
		<c:set var="weeks" value="5" />
		<c:set var="startDay" value="0"></c:set>
		<c:set var="startDate" value="1"></c:set>
		<div class="mainContainer">
			<div class="header">
				<a href="${root}/consumer/checkPassword.do?goingURL=update">회원수정</a>
				<a href="${root}/consumer/logout.do">로그아웃</a>
			</div>
			<div class="flexBox">
				<!-- input area -->
				<div class="infoBlock">
					<!-- input -->
					<div class="infoBlockSub info">
						<p>시작일 선택</p>
						<input type="date" id="selectedStartDate" />
						<br>
						<input id="selectStartHour" class="selectTime" type="text" value="${hour}" />
						<span>시</span>
						<input id="selectStartMinute" class="selectTime" type="text" value="${minute}" />
						<span>분</span>
						
						<p>종료일 선택</p>
						<input type="date" id="selectedEndDate" />
						<br>
						<input id="selectEndHour" class="selectTime" type="text" value="${hour == 23?hour:hour + 1}" />
						<span>시</span>
						<input id="selectEndMinute" class="selectTime" type="text" value="${minute}" />
						<span>분</span>
						<br/>
						
						<!-- 선택된 입력 종류에 따라 변경 -->
						
						<select id="selectAction" class="selectAction">
							<option value="event">Event</option>
							<!-- <option value="alarm">Alarm</option> -->
						</select>
						<button onclick="javascript:printSelectBox('${root}')" class="selectButton">선택</button>	
						<div class="selectBox" id="selectBox"></div>
					</div>
										
					<!-- explan -->
					<div class="infoBlockSub info">
						<p>일정 정보</p>
						<div class="infoBox" id="infoBox"></div>
					</div>
				</div>
			
				<div class="calendar">
					<div class="calendarTitle">
						<label id="calendarTitleID"></label>
						<script type="text/javascript">printCalendarTitle('${year}', '${month}');</script>
					</div>
					
					<!-- Loop 5 time -->
					<c:forEach begin="1" end="${weeks}" step="1">
						<ul class="weekBox">
							<c:forEach var="day" begin="${startDay}" end="${startDay + 6}" step="1">
								<c:set var="daysID" value="day${day}"></c:set>
								<li class="dayBox" role="button" onclick="javascript:console.log(${day})">
									
									<!-- print day(sun, mon...) -->
									<div class="dayTitle">
										<label class="day" id="${daysID}">day</label>
										<script type="text/javascript">printDayTitle2('${day}', '${daysID}');</script>
									</div>
									
									<!-- print date(1, 2, 3....) -->
									<div class="dayTitle">
										<label> 
											<!-- isSunday = 시작일이 일요일이 아닌가? -->
											<c:if test="${isSunday == false}">
												<!-- 1일의 이전달의 일수가 존재할 경우 -->
												<c:if test="${lastMontStartDay > lastDays}">
													<!-- 시작날 출력 -->
													<c:if test="${startDate > days}">
														<c:set var="startDate" value="1"></c:set>		
													</c:if>
													${startDate}
													<c:set var="startDate" value="${startDate + 1}"></c:set>
												</c:if>
												
												<c:if test="${lastMontStartDay <= lastDays}">
													${lastMontStartDay}
													<c:set var="lastMontStartDay" value="${lastMontStartDay + 1}"></c:set>
												</c:if>
											</c:if>
											 
											 <!-- isSunday = 시작일이 일요일인가? -->
											<c:if test="${isSunday == true}">
												<c:if test="${startDate > days}">
													<c:set var="startDate" value="1"></c:set>
												</c:if>
												<c:if test="${startDate <= days}">
													${startDate}
													<c:set var="startDate" value="${startDate + 1}"></c:set>
												</c:if>
											</c:if>
										</label>
									</div>
									
									<!-- 일정내용 -->
									<div class="dayContent">
										<c:forEach items="${eventList}" var="eventDto">
											<c:if test="${printCalendarEventMap.get(eventDto.eventCode).peek() == (startDate-1)}">
												<button class="dayContentTitle" 
												onclick="javascript:printDayContent('${eventDto.title}', '${eventDto.attendee}', '${eventDto.loc}', '${eventDto.explan}')">
													${eventDto.title}
												</button>
												<br>
												<c:set var="tmp" value="${printCalendarEventMap.get(eventDto.eventCode).poll()}"></c:set>
											</c:if>
										</c:forEach>
									</div>
								</li>
							</c:forEach>
							
							<!-- 일주일  단위 증가-->
							<c:set var="startDay" value="${startDay + 7}"></c:set>
						</ul>
					</c:forEach>
					
					<div class="calendarFooter">
						<div class="preMonth" onclick="location.href='${root}/calendar/calendar.do?year=${year}&month=${month-1}'">이전달</div>
						<div class="nextMonth" onclick="location.href='${root}/calendar/calendar.do?year=${year}&month=${month+1}'">다음달</div>
					</div>
					
				</div>
			</div>
		</div>
	</c:if>
</body>
</html>