<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>파일 게시판</h3>
	<a href="${root}/fileboard/write.do">파일 업로드</a>
	<a href="${root}/fileboard/list.do">파일 리스트</a>

	<h3>방명록 작성</h3>
	<a href="${root}/guest/write.do">방명록 쓰기</a>

	<h3>회원관리</h3>
	<c:if test="${id == null}">
		<a href="${root}/member/register.do">회원가입</a>
		<a href="${root}/member/login.do">로그인</a>
	</c:if>

	<c:if test="${id != null}">
		<a href="${root}/member/logout.do">로그아웃</a>
		<a href="${root}/member/update.do">회원수정</a>
		<a href="${root}/member/delete.do">회원탈퇴</a>
		write admin action
		<c:if test="${memberLevel == 'MA'}">
			<br>
			<h3>관리자 메뉴</h3>

		</c:if>
	</c:if>
	<h3>게시판</h3>
	<a href="${root}/board/write.do">글쓰기</a>
	<a href="${root}/board/list.do">글목록</a>
	<h3>한줄 댓글</h3>
	<a href="${root}/reply/list.do">한줄댓글가기</a>
</body>
</html>