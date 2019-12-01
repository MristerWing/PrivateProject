<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정</title>
<link rel="stylesheet" href="${root}/resources/css/common.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/register.css" />
<script type="text/javascript" src="${root}/resources/javascript/member/update.js"></script>
</head>
<body>
    <div align="center" style="margin: 0 auto">
		<div style="font-weight: bold;">회원수정(*필수입력사항입니다.)</div>
		<form action="${root }/member/updateOk.do" name="createForm" method="post" onsubmit="return registerForm(this)">
			<div class="liner">
				<label>아이디</label>
				<div class="insert">
					<span>*</span><input type="text" name="did" disabled="disabled" value="${id}" />
					<c:out value="회원등급: ${memberLevel}"></c:out>
					<input type="hidden" name = "id" value="${memberDto.num}"/>
				</div>
			</div>

			<div class="liner">
				<label>비밀번호</label>
				<div class="insert">
					<span>*</span><input type="password" name="password" value="${memberDto.password}"/>
				</div>
			</div>

			<div class="liner">
				<label>비밀번호 확인</label>
				<div class="insert">
					<span>*</span><input type="password" name="pwd_chk" value="${memberDto.password}"/>
				</div>
			</div>
			<div class="liner">
				<label>이름</label>
				<div class="insert">
					<span>*</span><input type="text" name="name" disabled="disabled" value="${memberDto.name}"/>
				</div>
			</div>
			<div class="liner">
				<label>주민번호</label>
				<div class="insert">
					<span>*</span><input type="text" name="jumin1" size="8" disabled="disabled" value="${memberDto.jumin1}" /><span> - </span><input type="password"
						name="jumin2" size="8" disabled="disabled" value="${memberDto.jumin2}" />
				</div>
			</div>
			<div class="liner">
				<label>이메일</label>
				<div class="insert">
					<input type="email" name="email" value="${memberDto.email}"/>
				</div>
			</div>
			<div class="liner">
				<label>우편번호</label>
				<div class="insert">
					<input type="text" name="zipcodeView" disabled="disabled" value="${memberDto.zipcode}"/> <input type="button" name="zipcode_search"
						value="우편번호검색" onclick="zipcodeRead('${root}')" />
						<input type="hidden" name="zipcode" value="${memberDto.zipcode}"/>
				</div>
			</div>
			<div class="liner">
				<label>주소</label>
				<div class="insert">
					<input type="text" name="address" size="45" value="${memberDto.address}"/>
				</div>
			</div>
			<div class="liner">
				<label>직업</label>
				<div class="insert">
					<select name="job" style="margin-left: 2px;">
						<option value="none"></option>
						<option value="pro">프로그래머</option>
						<option value="tch">선생님</option>
					</select>
				</div>
			</div>
			<div class="liner">
				<label>메일수신</label>
				<div class="insert">
					<input type="radio" name="mailing" value="yes"/>
					<span>yes</span>
					<input type="radio" name="mailing" value="no"/>
					<span>no</span>
				</div>
			</div>
			<div class="liner">
				<label>관심분야</label>
				<div class="insert">
				<input type="checkbox" name="interestValue" value="eco"/>
				<span>경제</span>
				<input type="checkbox" name="interestValue" value="it"/>
				<span>IT</span>
				<input type="checkbox" name="interestValue" value="music"/>
				<span>음악</span>
				<input type="checkbox" name="interestValue" value="art"/>
				<span>미술</span>
				<input type="hidden" name="interest"/>
				</div>
			</div>
			<%--forTkoens--%>
			<%-- <c:forTokens var="interest" items="${memberDto.interest}" delims=",">
				<script type="text/javascript">
					for(var i = 0;i < createForm.interestValue,length;i++) {
						if(createForm.interestValue[i].value == interest) {
							createForm.interestValue[i].checked = true;
						}
					}
				</script>
			</c:forTokens> --%>
			<div class="liner" style="border-bottom-width: 0px;">
				<input type="submit" value="수정완료" />
				<input type="reset" value="취소" onclick="location.href='${root}/index.jsp'"/>
			</div>
			<%-- <c:set var="interestIndex" value="${fn:split(memberDto.interest, ',')}"></c:set> --%>
			<%-- <c:out value="${interestIndex[0]}"/> --%>
			<script type="text/javascript">
				setValues(createForm, '${memberDto.job}', '${memberDto.mailing}', '${memberDto.interest}');
			</script>
		</form>
	</div>
</body>
</html>