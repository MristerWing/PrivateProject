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
<link rel="stylesheet" href="${root}/css/consumer/register.css" />
<script type="text/javascript" src="${root}/javascript/consumer/register.js"></script>
</head>
<body>
	<div class="wrap">
      <div class="mainContainer">
        <div class="logo"><span class="logoContent">LOGO</span></div>
        <div class="registerBox">
          <form id="form" action="${root}/consumer/registerOk.do" method="post" onsubmit="return registerCheck(this)">
            <ul>
              <li>
                <label class="lineText" for="ID">아이디 2~13 영문자 숫자 조합</label
                ><input type="text" name="ID" id="ID" size="13.6" />
                <input type="button" class="checkIdButton" value="확인" onclick="checkId(form, '${root}')">
                <span id="checkId"></span>
                <input type="hidden" name="isCheckedID" />
              </li>
              <br>
              <li>
                <label class="lineText" for="name">이름</label
                ><input type="text" name="name" id="name" />
                <span id="checkName"></span>
              </li>
              <br>
              <li>
                <label class="lineText" for="password">비밀번호 8~13 영문자 숫자 조합</label
                ><input type="password" name="password" id="password" />
              </li>
              <li>
                <label class="lineText" for="checkPassword">비밀번호 확인</label
                ><input type="password" name="checkPassword" id="checkPassword" />
                <span id="checkPassword"></span>
              </li>
              <br>
              <li>
                <label class="lineText" for="email">email</label
                ><input type="email" name="email" id="email" />
                <span id="checkEmail"></span>
              </li>
              <br>
              <li>
                <label class="lineText" for="findPassword"
                  >비밀번호 찾기 문자</label
                ><input type="text" name="findPassword" id="findPassword" />
                <span id="checkFindPassword"></span>
              </li>
              <br>
              <li><input type="submit" value="가입" class="registerButton"/></li>
            </ul>
          </form>
        </div>
      </div>
    </div>
</body>
</html>