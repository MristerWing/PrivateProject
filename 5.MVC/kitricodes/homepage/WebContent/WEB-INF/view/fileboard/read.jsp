<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>${boardDto.subject}</title>
<link rel="stylesheet" href="${root}/css/common.css" />
<link rel="stylesheet" href="${root}/css/board/read.css" />
<script type="text/javascript"
	src="${root}/javascript/fileboard/read.js"></script>
</head>
<body>
	<jsp:include page="../../../index.jsp"></jsp:include>
	<div align="center" class="wrap">
		<div class="main">
			<ul>
				<li class="menu subject">${boardDto.subject}</li>
				<li class="menu menu-f">글번호</li>
				<li class="menu">${boardDto.boardNumber}</li>

				<li class="menu">조회수</li>
				<li class="menu menu-l">${boardDto.readCount}</li>
			</ul>

			<ul>
				<li class="menu menu-f">작성자</li>
				<li class="menu">${boardDto.writer}</li>

				<li class="menu">작성일</li>
				<li class="menu menu-l"><fmt:formatDate
						value="${boardDto.writeDate}" pattern="yyyy-MM-dd hh:mm:ss" /></li>
			</ul>

			<ul class="contentLayout">
				<li class="content subjectC"><span>글내용</span></li>
				<li class="content contentC">${boardDto.content}${fn:replace(boardDto.fileName, "\", "/")}</li>
			</ul>
			<c:if test="${boardDto.fileName != null}">
				<ul class = "fileBox">
					<li class="subjectC" style="display: inline-block;">파일</li>
					<li class="contentC" style="display: inline-block; text-align: right;">
						<c:forTokens var="i" begin="1" items="${boardDto.fileName}" delims="_">
							<button class="filebutton" onclick="">${i}</button>
						</c:forTokens>
					</li>
				</ul>
			</c:if>

			<ul>
				<li class="bottom"><input type="button" value="글수정"
					onclick="javascript:location.href='${root}/fileboard/update.do?pageNumber=${pageNumber}&boardNumber=${boardDto.boardNumber}'" />
					<input type="button" value="글삭제"
					onclick="deleteFun('${root}', '${pageNumber}', '${boardDto.boardNumber}', '${boardDto.password}', '${boardDto.fileName}', '${boardDto.path}')" />
					<input type="button" value="답글"
					onclick="replyFun('${root}', '${boardDto.boardNumber}', '${boardDto.groupNumber}', '${boardDto.sequenceNumber}', '${boardDto.sequenceLevel}', '${pageNumber}', 'write')" />
					<input type="button" value="글목록"
					onclick="javascript:location.href='${root}/fileboard/list.do?pageNumber=${pageNumber}'" />
				</li>
			</ul>
		</div>
	</div>
</body>
</html>