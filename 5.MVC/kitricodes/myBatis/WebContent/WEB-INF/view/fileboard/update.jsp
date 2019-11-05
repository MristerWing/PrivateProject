<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<link rel="stylesheet" href="${root}/css/common.css" />
<link rel="stylesheet" href="${root}/css/board/write.css" />
<script type="text/javascript"
	src="${root}/javascript/fileboard/update.js"></script>
</head>
<body>
	<jsp:include page="../../../index.jsp"></jsp:include>
	<div align="center" class="wrap">
		<h3>boardNum:${boardNumber}</h3>
		<div class="top" style="font-weight: bold;">글쓰기</div>
		<div class="top" style="text-align: right;">
			<a href="${root}/fileboard/list.do?pageNumber=${pageNumber}">글목록</a>
		</div>
		<form class="mainContainer"
			action="${root}/fileboard/updateOk.do?pageNumber=${pageNumber}"
			method="post"
			onsubmit="return boardForm(this, '${boardDto.password}')"
			enctype="multipart/form-data">
			<input type="hidden" name="boardNumber" value="${boardNumber}" />

			<div class="liner">
				<label>작성자</label>
				<div class="insert">
					<input type="text" size="20" name="writer"
						value="${boardDto.writer}" />
				</div>
			</div>
			<div class="liner">
				<label>제목</label>
				<div class="insert">
					<input type="text" size="50" name="subject"
						value="${boardDto.subject}" />
				</div>
			</div>
			<div class="liner">
				<label>이메일</label>
				<div class="insert">
					<input type="email" size="50" name="email"
						value="${boardDto.email}" disabled="disabled" />
				</div>
			</div>
			<div class="liner texta">
				<label class="texta">내용</label>
				<textarea rows="13" cols="62" name="content">${boardDto.content}</textarea>
			</div>

			<div class="liner">
				<label>파일명</label>
				<div class="insert">
					<c:if test="${boardDto.fileName != null}">
						<span style="font-size: 12px">${boardDto.fileName}</span>
						<input type="file" size="40" name="file" />
					</c:if>
					<c:if test="${boardDto.fileName == null}">
						<input type="file" size="50" name="file" />
					</c:if>
				</div>
			</div>

			<div class="liner">
				<label>비밀번호</label>
				<div class="insert">
					<input type="password" size="20" name="password" />
				</div>
			</div>
			<div class="liner" style="border-bottom-width: 0px;">
				<input type="submit" value="수정" /> <input type="reset" value="다시작성" />
				<input type="button" value="목록보기"
					onclick="javascript:location.href='${root}/fileboard/list.do?pageNumber=${pageNumber}'" />
			</div>
		</form>
	</div>
</body>
</html>