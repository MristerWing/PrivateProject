<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FMT</title>
</head>
<body>
	<h3>문자열 숫자로 변환</h3>
	<c:set var="numStr" value="${'100'}"></c:set>
	<c:out value="${numStr}"></c:out>
	
	<br>
	<br>
	
	<fmt:parseNumber var="pNum" value="${numStr}"></fmt:parseNumber>
	<c:if test="${pNum == 100}">
		<h4>
			<c:out value="${pNum}"></c:out>
			은 숫자 타입입니다!
		</h4>
	</c:if>
	
	<%--type cast. 실수형 데이터를 정수형으로 변경 --%>
	<fmt:parseNumber var="changeInt" value="55.7" integerOnly="true"></fmt:parseNumber>
	<c:out value="${isInt}"></c:out>
	
	<c:set var="floatN1" value="55.5"></c:set>
	<c:set var="floatN2" value="66.7"></c:set>
	<c:set var="result" value="${floatN1 + floatN2}"></c:set>
	<fmt:parseNumber var="parseNum" value="${result}" integerOnly="true"></fmt:parseNumber>
	
	<c:out value="float data is ${result}"/>
	<br>
	<br>
	<c:out value="change a int is ${parseNum }"/>
	
	<h3>숫자 패턴</h3>
	<c:set var="numStr" value="123456"/>
	<fmt:formatNumber value="${numStr}" type="number"></fmt:formatNumber>
	<br>
	<br>
	<%--currencySSybol을 사용하면 패턴 타입을 변경가능(기본은 윈도우의 구성을 따라감)--%>
	<fmt:formatNumber value="${numStr}" type="currency" currencySymbol="$"></fmt:formatNumber>
	<br>
	<br>
	<fmt:formatNumber value="${numStr}" type="percent"></fmt:formatNumber>
	<br>
	<br>
	
	<h3>pattern</h3>
	<%--
		pattern은 직접 패턴을 지정하여 사용한다.
		#과 0의 차이는 뒤에 남는 자릿수가 0으로 채워지는가 아닌가의 차이이다.
		java의 decimalFormat을 참고할 것.
	--%>
	<c:set var="fNum" value="56678.11668"></c:set>
	<c:out value="Origin num: ${fNum}"></c:out>
	<br>
	<br>
	<fmt:formatNumber value="${fNum}" pattern="0.00"></fmt:formatNumber>
	<br>
	<br>
	<fmt:formatNumber value="${fNum}" pattern="0.0000"></fmt:formatNumber>
	<br>
	<br>
	<fmt:formatNumber value="${fNum}" pattern="#.##"></fmt:formatNumber>
	<br>
	<br>
	<fmt:formatNumber value="${fNum}" pattern="#.####"></fmt:formatNumber>
	<br>
	<br>
	<fmt:formatNumber value="${fNum}" pattern="#,##,##.#"></fmt:formatNumber>
	<br>
	<br>
	
</body>
</html>