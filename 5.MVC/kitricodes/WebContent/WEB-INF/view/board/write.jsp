<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" href="${root}/css/common.css" />
<link rel="stylesheet" href="${root}/css/board/write.css" />
<script type="text/javascript" src="${root}/javascript/board/write.js"></script>
</head>
<body>
	<jsp:include page="../../../index.jsp"></jsp:include>
	<div align="center" class="wrap">
		<h3> boardNum:${boardNumber} groupNum: ${groupNumber} sequenceNum: ${sequenceNumber} sequencelevel: ${sequencelevel}</h3>
		<div class="top" style="font-weight: bold;">글쓰기</div>
		<div class="top" style="text-align: right;">
			<a href="#">글목록</a>
		</div>
		<form action="${root}/board/writeOk.do" method="post" onsubmit="return boardForm(this)">
			<input type="hidden" name="boardNumber" value="${boardNumber}" />
			<input type="hidden" name="groupNumber" value="${groupNumber}" />
			<input type="hidden" name="sequenceNumber" value="${sequenceNumber}" />
			<input type="hidden" name="sequenceLevel" value="${sequencelevel}" />
			
			<div class="liner">
				<label>작성자</label>
				<div class="insert"><input type="text" size="20" name="writer" value="김진수"/></div>
			</div>
			<div class="liner">
				<label>제목</label>
				<div class="insert"><input type="text" size="50" name="subject" value="테스트작성글 입니다."/></div>
			</div>
			<div class="liner">
				<label>이메일</label>
				<div class="insert"><input type="email" size="50" name="email" value="gmx0807@gmail.com"/></div>
			</div>
			<div class="liner texta">
				<label class="texta">내용</label>
				<textarea rows="13" cols="62" name="content">Test</textarea>
			</div>
			<div class="liner">
				<label>비밀번호</label>
				<div class="insert"><input type="password" size="20" name="password" value="1111"/></div>
			</div>
			<div class="liner" style="border-bottom-width: 0px;">
				<input type="submit" value="글쓰기"/>
				<input type="reset" value="다시작성"/>
				<input type="button" value="목록보기" onclick="boardForm(this)"/>
			</div>
		</form>
	</div>
</body>
</html>