<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="${root}/css/common.css" />
<link rel="stylesheet" href="${root}/css/consumer/login.css" />
<script type="text/javascript" src="${root}/javascript/consumer/login.js"></script>
</head>
<body>
	<div class="wrap">
      <div class="mainContainer">
          <div class="logo"><span class="logoContent">Calendar</span></div>
        <form action="${root}/consumer/loginCheck.do" method="post">
          <ul class="loginBox">
            <li class="lineText"><span style="margin-right: 20px;">아이디:</span><input type="text" name="ID" /></li>
            <li class="lineText"><span style="margin-right: 4px;">비밀번호:</span><input type="password" name="password" /></li>
            <!-- <li class="lineText">
              <a href="http://">아이디 찾기</a>
              <span>/</span>
              <a href="http://">비밀번호 찾기</a>
            </li> -->
            <li>
            	<input class="loginButton" type="button" value="회원가입" onclick="javascript:location.href='${root}/consumer/register.do'" />
            	<input class="loginButton" type="submit" value="Login" />
            </li>
          </ul>
        </form>
      </div>
    </div>
</body>
</html>