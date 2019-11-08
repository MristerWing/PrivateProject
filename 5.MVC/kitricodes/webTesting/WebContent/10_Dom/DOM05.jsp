<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="javascript/DOM05.js"></script>
</head>
<body>
	<form action="#" method="GET" onsubmit="return checkForm()" id="createForm">
        <label>이름을 입력하세요.</label>
        <input type="text" name="name" id="name" />
        <br />
        <br />

        <label>이동할 사이트 선택</label>
        <select name="siteUrl" id="siteURL">
            <option></option>
            <option value="https://www.naver.com">naver</option>
            <option value="https://www.daum.net">daum</option>
            <option value="https://www.google.com">google</option>
        </select>
        <br />
        <br />
        
		<!-- DOM에서 checkbox하고 radio는 id 못씀 -->
        <label>좋아하는 과일 선택</label>
        <br />
        <br />
        <input type="radio" name="fruit" value="바나나" />
        <label>바나나</label>

        <input type="radio" name="fruit" value="사과" />
        <label>사과</label>

        <input type="radio" name="fruit" value="딸기" />
        <label>딸기</label>

        <input type="radio" name="fruit" value="파인애플" />
        <label>파인애플</label>
        <br />
        <br />

        <label>관심사 체크</label>
        <br />
        <br />
        <input type="checkbox" name="interset" value="경제" class="interest"/>
        <label>경제</label>

        <input type="checkbox" name="interset" value="IT" class="interest" />
        <label>IT</label>

        <input type="checkbox" name="interset" value="미술" class="interest" />
        <label>미술</label>

        <input type="checkbox" name="interset" value="음악" class="interest" />
        <label>음악</label>
        <br />
        <br />

        <input type="hidden" name="result" />

        <input type="submit" value="전송" />
        <input type="reset" value="취소" />
    </form>
</body>
</html>