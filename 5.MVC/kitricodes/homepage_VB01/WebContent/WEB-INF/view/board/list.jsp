<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>목록 보기</title>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="${root}/css/common.css" />
<link rel="stylesheet" href="${root}/css/board/list.css" />
</head>
<body>
	<jsp:include page="../../../index.jsp"></jsp:include>
	<div class="wrap">
		<div align="center" class="header">
			<div>
				<p class="wirte">
					<a href="${root}/board/write.do?pageNumber=${currentPage}">글쓰기</a>
				</p>
			</div>
		</div>

		<c:if test="${count ==0 || boardList.size() == 0}">
			<div>
				<div>
					<label class="content">게시판에 작성된 글이 없습니다.</label>
				</div>
			</div>
		</c:if>

		<c:if test="${count > 0}">
			<div class="main">
				<ul>
					<li class="menu" style="width: 40px; border-left-width: 0" >번호</li>
					<li class="menu" style="width: 250px;">제목</li>
					<li class="menu" style="width: 70px;">작성자</li>
					<li class="menu" style="width: 200px;">작성일</li>
					<li class="menu" style="width: 60px">조회수</li>
				</ul>

				<c:forEach var="boardDto" items="${boardList}">
					<ul>
						<li class="menu" style="width: 40px; border-left-width: 0">${boardDto.boardNumber}</li>
						<li class="menu" style="width: 250px;">
						<c:if test="${boardDto.sequenceLevel > 0}">
							<c:forEach begin="0" end="${boardDto.sequenceLevel}" step="1">
								&nbsp;&nbsp;&nbsp;
							</c:forEach>
							<i class="pointer fa fa-flag"></i>
						</c:if>
						<a href="${root}/board/read.do?boardNumber=${boardDto.boardNumber}&pageNumber=${currentPage}">${boardDto.subject}</a>
						</li>

						<li class="menu" style="width: 70px;">${boardDto.writer}</li>
						<li class="menu" style="width: 200px;"><fmt:formatDate value="${boardDto.writeDate}"
								pattern="yyy-MM-dd hh:mm:ss" /></li>
						<li class="menu" style="width: 60px">${boardDto.readCount}</li>
					</ul>
				</c:forEach>
			</div>
		</c:if>
		<br> <br>

		<div align="center">
			<c:if test="${count > 0}">
				<c:set var="pageBlock" value="${10}"></c:set>
				<c:set var="pageCount"
					value="${count/boardSize+(Count%boardSize==0?0:1)}"></c:set>

				<fmt:parseNumber integerOnly="true" var="result"
					value="${(currentPage-1)/pageBlock}"></fmt:parseNumber>

				<c:set var="startPage" value="${result*pageBlok+1}" />
				<c:set var="endPage" value="${startPage+pageBlock-1}" />

				<c:if test="${endPage > pageCount}">
					<c:set var="endPage" value="${pageCount}" />
				</c:if>

				<c:if test="${startPage > pageBlock}">
					<a href="${root}/board/list.do?pageNumber=${startPage-pageBlock}">[이전]</a>
				</c:if>

				<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
					<a href="${root}/board/list.do?pageNumber=${i}">[${i}]</a>
				</c:forEach>

				<c:if test="${endPage < pageCount}">
					<a href="${root}/board/list.do?pageNumber=${startPage+pageBlock}">[다음]</a>
				</c:if>
			</c:if>
		</div>
	</div>
</body>
</html>