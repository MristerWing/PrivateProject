<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
	<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="${root}/css/common.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/member/register.css" />
<script type="text/javascript" src="${root}/javascript/member/register.js"></script>
</head>
<body>
	<jsp:include page="../../../index.jsp"/>
	<br>
	<br>
	
    <div align="center" style="margin: 0 auto">
		<div style="font-weight: bold;">회원가입(*필수입력사항입니다.)</div>
		<form action="${root }/member/registerOk.do" name="createForm" method="post" onsubmit="return registerForm(this)">
			<div class="liner">
				<label>아이디</label>
				<div class="insert">
					<span>*</span><input type="text" name="id" /> <input type="button"
						value="아이디중복" onclick="idCheck(createForm, '${root}')"/>
						<input type="hidden" name="isIdChk" />
				</div>
			</div>

			<div class="liner">
				<label>비밀번호</label>
				<div class="insert">
					<span>*</span><input type="password" name="password" />
				</div>
			</div>

			<div class="liner">
				<label>비밀번호 확인</label>
				<div class="insert">
					<span>*</span><input type="password" name="pwd_chk" />
				</div>
			</div>
			<div class="liner">
				<label>이름</label>
				<div class="insert">
					<span>*</span><input type="text" name="name" />
				</div>
			</div>
			<div class="liner">
				<label>주민번호</label>
				<div class="insert">
					<span>*</span><input type="text" name="jumin1" size="8" /><span> - </span><input type="password"
						name="jumin2" size="8" />
				</div>
			</div>
			<div class="liner">
				<label>이메일</label>
				<div class="insert">
					<input type="email" name="email" />
				</div>
			</div>
			<div class="liner">
				<label>우편번호</label>
				<div class="insert">
					<input type="text" name="zipcodeView" disabled="disabled"/> <input type="button" name="zipcode_search"
						value="우편번호검색" onclick="zipcodeRead('${root}')" />
						<input type="hidden" name="zipcode" />
				</div>
			</div>
			<div class="liner">
				<label>주소</label>
				<div class="insert">
					<input type="text" name="address" size="45" />
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
			<div class="liner" style="border-bottom-width: 0px;">
				<input type="submit" value="가입" /><input type="reset" value="취소" />
			</div>
		</form>

	</div>
</body>
</html>