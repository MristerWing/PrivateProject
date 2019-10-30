<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 검색</title>
<link rel="stylesheet" href="${root}/css/common.css" />
<link rel="stylesheet" href="${root}/css/member/zipcode.css" />
<script type="text/javascript" src="${root}/javascript/member/register.js"></script>
</head>
<body>
	<div align="center" style="width: 100%; margin: 0 auto;">
		<form action="${root}/member/zipcode.do" method="get">
			<div>
				<input type="text" name="dong" /> <input type="submit" value="확인" />
			</div>
		</form>
	</div>

	<div>
		<c:if test="${zipcodeList.size() == 0}">
			<div>
				<span>검색된 결과값이 없습니다.</span><br>
			</div>
		</c:if>

		<c:if test="${zipcodeList.size() > 0}">
			<div>
				<p>아래의 우편번호를 클릭하세요.</p>
			</div>

			<div>
				<c:forEach var="zipDto" items="${zipcodeList}" step="1">
					<div>
						<ul>
							<li><a
								href="javascript:sendAddress(
							'${zipDto.zipcode}', '${zipDto.sido}', '${zipDto.gugun}',
								'${zipDto.dong}', '${zipDto.ri}', '${zipDto.bunji}'
							)">
									${zipDto.zipcode} ${zipDto.sido} ${zipDto.gugun} ${zipDto.dong}
									${zipDto.ri} ${zipDto.bunji}</a></li>
						</ul>
					</div>
				</c:forEach>
			</div>
		</c:if>
	</div>

</body>
</html>