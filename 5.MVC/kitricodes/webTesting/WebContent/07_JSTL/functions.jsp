<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Function</title>
</head>
<body>
	<c:set var="str1" value="Function 태그를  사용합니다."></c:set>
	<c:set var="str2" value="사용"></c:set>
	<c:set var="str3" value="1, 2, 3, 4, 5, 6, 7, 8, 9, 10"></c:set>
	<div>
		str1: <c:out value="${str1 }"></c:out><br>
		str2: <c:out value="${str2 }"></c:out><br>
		str3: <c:out value="${str3 }"></c:out><br>
	</div>
	
	<hr/>
	
	<div>
		문자열 길이: ${fn:length(str1)}<br>
		대문자: ${fn:toUpperCase(str1)}<br>
		소문자: ${fn:toLowerCase(str1)}<br>
		추출: ${fn:substring(str1, 3, 6 )}<br>
		치환: ${fn:replace(str1, " ", "-")}<br>
		위치반환: ${fn:indexOf(str1, "t")}<br>
		
		문자열1에서 문자열2에 포함되어 있는 문자열 이후 : ${fn:substringAfter(str1, str2)}<br>
		문자열1에서 문자열2에 포함되어 있는 문자열 이전 : ${fn:substringBefore(str1, str2)}<br>
		시작 문자열: ${fn:startsWith(str1, 'Fun')}<br>
		시작 문자열: ${fn:startsWith(str1, 'abc')}<br>
		끝 문자열: ${fn:endsWith(str1, 'Fun')}<br>
		문자열1에 문자열2가 포함되는가?: ${fn:contains(str1, str2)}<br>
		문자열1에 문자열2가 포함되는가?(대소문자 구분 X): ${fn:containsIgnoreCase(str1, str2)}<br>
		
		split
		<c:set var="array" value="${fn:split(str3, ',')}"></c:set><br>
		<c:forEach var="i" items="${array}">
			<c:out value="${i}"></c:out><br>
		</c:forEach>
		<br>
	</div>
</body>
</html>