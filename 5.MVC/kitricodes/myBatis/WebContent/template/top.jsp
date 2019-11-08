<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>FirstPage</title>
<link rel="stylesheet" href="${root}/css/common.css" />
<link rel="stylesheet" href="${root}/css/template/top.css" />
</head>
<body>
	<div class="indexMenu">
		<h3>회원관리</h3>
		<c:if test="${id == null}">
			<a href="${root}/member/register.do">회원가입</a>
			<br>
			<a href="${root}/member/login.do">로그인</a>
			<br>
		</c:if>

		<c:if test="${id != null}">
			<a href="${root}/member/logout.do">로그아웃</a>
			<br>
			<a href="${root}/member/update.do">회원수정</a>
			<br>
			<a href="${root}/member/delete.do">회원탈퇴</a>
			<%--write admin action--%>
			<c:if test="${memberLevel == 'MA'}">
				<h3>관리자 메뉴</h3>
			</c:if>
		</c:if>
	</div>
	<div class="indexMenu">
		<h3>방명록</h3>
		<a href="${root}/guest/write.do">글쓰기</a>
		<br>
		<br>
	</div>
	<div class="indexMenu">
		<h3>게시판</h3>
		<a href="${root}/board/write.do">게시글 쓰기</a> <br> <a
			href="${root}/board/list.do">목록보기</a>
	</div>
	<div class="indexMenu">
		<h3>파일게시판</h3>
		<a href="${root}/fileboard/write.do">게시글 쓰기</a> <br> <a
			href="${root}/fileboard/list.do">목록보기</a>
	</div>
</body>
</html>