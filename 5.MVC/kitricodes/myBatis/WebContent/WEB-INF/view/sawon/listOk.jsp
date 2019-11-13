<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div>
		<div class = "sawonMain">
			<ul class="sawonName">
				<li class="sawonList" style="width: 50px">사번</li>
				<li class="sawonList" style="width: 100px">이름</li>
				<li class="sawonList" style="width: 260px">입사일</li>
				<li class="sawonList" style="width: 100px">직종</li>
				<li class="sawonList" style="width: 60px">급여</li>
				<li class="sawonList" style="width: 80px">부서번호</li>
				<li class="sawonList" style="width: 100px">부서명</li>
			</ul>
		</div>
		<c:forEach var="list" items="${sawonList}">
			<div class="sawonMain">
				<ul>
					<li class="sawonList" style="width: 50px">${list.employee_id}</li>
					<li class="sawonList" style="width: 100px">${list.first_name}</li>
					<li class="sawonList" style="width: 260px">${list.hire_date}</li>
					<li class="sawonList" style="width: 100px">${list.job_id}</li>
					<li class="sawonList" style="width: 60px">${list.salary}</li>
					<li class="sawonList" style="width: 80px">${list.department_id}</li>
					<li class="sawonList" style="width: 100px">${list.department_name}</li>
				</ul>
			</div>
		</c:forEach>
	</div>
</body>
</html>



