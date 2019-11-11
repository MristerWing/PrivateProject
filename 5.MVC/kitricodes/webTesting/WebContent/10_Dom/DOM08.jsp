<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function sub() {
	var father = document.getElementById("father");
	var grandfather = father.parentNode;
	
	var dauther = document.getElementById("dauther");
	var dautherparent = document=dauther.parentNode;
	
	var dauthergrandfather=dauther.parentNode.parentNode;
	
	var disp=document.getElementById("disp");
	var str=grandfather.nodeName + "<br/>";  <%-- 태그네임 --%>
	str += grandfather.nodeValue+ "<br/>";	<%-- 값 null --%>
	str+= grandfather.nodeType+ "<br/>";	<%-- 태그타입 1 --%>
	
	str+=dautherparent.nodeName +"<br/>";
	str+=dautherparent.nodeValue+"<br/>";
	str+=dautherparent.nodeType+"<br/>";
	
	str +=dauthergrandfather.nodeName + "<br/>";
	str +=dauthergrandfather.nodeValue + "<br/>";
	str += dauthergrandfather.nodeType + "<br/>";
	
	disp.innerHTML=str;
}

</script>
</head>
<body onload="sub()"> <%-- 부모노드를 뽑아올일은많지않고 자식이나 형제가 많음 --%>
	<div id="grandfather"> <%--div태그가 몇개안될때 div태그를 전체 ,firstSon를 뽑으려면 father를 기준 , grandfather를 기준 3가지 방법 --%>
		<div id = father>
			<span id="firstSon">첫번째</span>
			<span id="dauther">두번째</span>
			<span id="secondSon">세번째</span>
		</div>
	</div>
	
	<div id = "disp" style="color: blue;"></div>
</body>
</html>