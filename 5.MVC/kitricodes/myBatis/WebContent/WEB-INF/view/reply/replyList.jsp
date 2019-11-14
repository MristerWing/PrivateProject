<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>Reply</title>
<link rel="stylesheet" href="${root}/css/common.css" />
<link rel="stylesheet" href="${root}/css/reply/reply.css" />
<script type="text/javascript" src="${root}/xhr/xhr.js"></script>
<script type="text/javascript" src="${root}/javascript/reply/replyWrite.js"></script>
<script type="text/javascript" src="${root}/javascript/reply/replyDelete.js"></script>
<script type="text/javascript" src="${root}/javascript/reply/replyUpdate.js"></script>
</head>
<body>
	<!-- 새 댓글 -->
	<div>한줄 댓글이 가능합니다.</div>
	
	<div>
		<input type="text" name="write" id="writeReply" size="45" />
		<input type="button" value="한줄답글 작성" onclick="writeToServer('${root}')" />
	</div>
	<!-- 기존 댓글 -->
	<div id="listAllDiv">
		<c:if test="${replyList != null}">
			<c:forEach var="replyDto" items="${replyList}">
				<div id="reply${replyDto.bunho}" class="replyDiv">
					<label class="cssBunho">${replyDto.bunho}</label>
					<label class="cssReply">${replyDto.line_reply}</label>
					<span class="cssUpDel">
						<a href="javascript:deleteToServer('${replyDto.bunho}', '${root}')">삭제</a>
						<a href="javascript:updateToServer('${replyDto.bunho}', '${root}')">수정</a>
					</span>
				</div>
			</c:forEach>
		</c:if>
	</div>
</body>
</html>