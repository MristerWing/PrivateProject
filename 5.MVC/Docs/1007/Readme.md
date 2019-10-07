10/07
===
### 기타사항

1. 톰캣이나 오라클DB같은 서버 프로그램들은 서로 충돌이 날 수 있어서 하나는 레지스트리 등록을 하지않고 설치하는 것이 좋다.(non-setup)
2. 사이트에서 파일을 받을 때 Readme와 파일을 확인 할 것
3. server설치시 serverPath확인할것
4. url 구조:ip:port/directory
5. protocol(규약)이랑 권고안의 차이.
6. 컴파일러, 스크립트, 인터프리터
7. singleTag(br, image, input...)
8. 현 시점에서 HTML은 데이터를 뿌려주는 구분자 역할만을 수행한다.
9. 데이터를 가져오는 것은 XML과 JSON으로 가능하다.
10. CSS에서 템플릿을 만들 때 BLOCK Tag를 사용한다.

---
### .properties

* .properties는 응용프로그램의 구성 가능한 파라미터들을 저장하기 위해 자바 관련 기술을 주로 사용하는 파일들을 위한 파일 확장자이다. 국제와 지역화를 위한 문자열들을 저장하는데 사용할 수도 있는데 이것을 Property Resource Bundles로 부른다. 각 피라미터는 문자열들의 이부로 저장되는데, 한 문자열은 피라미터의 이름(키)를 저장하며, 다른 하나는 값을 저장한다.
* .properties의 각 줄은 일반적으로 하나의 프로퍼티를 저장한다. 키=값, 키 = 값, 키:값, 키 값과 같이 여러 형태가 올 수 있다.
* .properties 파일에서 주석은 줄 맨 앞에 #이나 !로 시작하며, 이 때 해당 줄의 나머지 문자열들은 모두 무시된다.

> 출처: https://ko.wikipedia.org/wiki/.properties

### .json(javaScript Object Notation)

* json은 속성-값 쌍( attribute–value pairs and array data types (or any other serializable value)) 또는 키-값쌍으로 이루어진 데이터 오브젝트를 전달하기 위해 인간이 읽을 수 있는 텍스트를 사용하는 개방형 표준 포맷이다.
* 비동기 브라우저/서버 통신(AJAX)을 위해, 넓게는 XML(AJAX가 사용)을 대처하는 주요 데이터 포맷이다.
* 자료의 종류에는 큰 제한은 없으며 컴퓨터 프로그램의 변수값을 표현하는 데 적합하다.

> 출처: https://ko.wikipedia.org/wiki/JSON

### WAR(WebApplication Archive)

* WAR은 약자 그대로 웹 어플리케이션 저장소를 의미하며 웹 어플리케이션을 압축해 저장해 놓은 파일이다.
* 개발한 웹 어플리케이션 프로젝트가 WAS에서 돌아갈 수 있는 구조를 담고 있으며, JSP및 서를릿 빈클래스등의 소스가 컴파일 되어 저장되며 기타 이미지 및 자원들이 포함되어 있다.

>출처: https://dololak.tistory.com/31

### port

* portNumber는 0 ~ 65536
    1. 0 ~ 1023 : Well Known Port(IANA에서 할당한 TCP, UDP포트), 유명서버, 특정서버
    2. 1024 ~ 49151 : Registered Port(기관이나 사업자들을 위해 IANA에서 관리하는 포트)
    3. 49152 ~ 65535 : Dynamic Port(일반사용자들이 자유롭게 사용할 수 있는 포트)

* portNumber는 일반적으로 IP주소 뒤에 콜론(:)을 이용하여 표기
* 잘알려진 port
    1. 20: FTP data< TCP>
    2. 21: FTP 제어< TCP>
    3. 22 : SSH< TCP>
    4. 23 : Telent< TCP>
    5. 25 : SMTP< TCP>
    6. 53 : DNS<TCP, UDP>
    7. 80 : HTTP<TCP, UDP>
    8. 110 : POP3< TCP>
    9. 443 : HTTPS< TCP>

> 출처: https://blockdmask.tistory.com/195

### HTML
![html](../img/html.png)

* head기준 구조
<pre><code><메타데이터 !DOCTYPE html>
<부모 html>
    <본인 head>
        <자식 meta charset="UTF-8">
        <자식 title>Insert title here(text, data)<자식 /title>
    <본인 /html>
    <형제 body>
	    HelloWorld!!
    <형제 /body>
<부모 /html></code></pre>

* W3C에서 권고안으로 개발되었다.
* HTML은 웹브라우저 표현언어이다.
* HTML의 구성은 Tag와 Text(Data)로 이루어져 있다.
* Tag는 기능적 역할과 데이터 구분자로 역할로 이루어져 있다.
* HTML Tag는 대소문자를 구분하지 않는다.(즉, 데이터 제외) 내부적으로 인터프리터가 전부 대문자로 바뀐다.
* HTML은 페이지의 **멀티미디어, 구분자, 링크**를 담당한다.

### JavScript:DOM(The Document Object Model)

* DOM이란 HTML, XML문서의 프로그래밍 interface이다. DOM은 구조화된 표현을 제공하며 프로그래밍 언어가 DOM구조에 접근할 수 있는 방법을 제공하여 그들이 문서 구조, 스타일, 내용 등을 변경할 수 있게 돕는다.
* DOM은 구조화된 nodes와 property와 method를 갖고 있는 objects로 문서를 표현한다.

>출처: https://developer.mozilla.org/ko/docs/Web/API/Document_Object_Model/%EC%86%8C%EA%B0%9C

### JavaScript:Core

* ECMAScript라고도 한다.
* 문법, 타입, 선언문, 키워드, 예약어, 연산자, 객체등 언어의 저수준에 해당하는 부분이다.
* 웹브라우저에 종속되지않으며, 브라우저는 ECMAScript를 구현하는 호스팅 환경일 뿐이다.

>출처: https://boycoding.tistory.com/2

### HTTP(HyperTextTransferProtocol)

* www상에서 정보를 주고 받을 수 있는 프로토콜이다. 주로 HTML 문서를 주고 받는데에 쓰인다.
* TCP & UDP를 사용하며, 80번 포트를 사용한다.

>출처: https://ko.wikipedia.org/wiki/HTTP

### mybatis

* mybatis는 개발자가 지정한 SQL, 저장프로시저 그리고 몇가지 고급 매핑을 지원하는 퍼시스턴스 프레임워크이다.

>출처: https://mybatis.org/mybatis-3/ko/index.html

### XML(ExtensibleMarkupLanguage)

* W3C에서 개발된, 다른 특수한 목적을 갖는 마크업 언어를 만드는데 권장하는 다목적 마크업 언어이다.

> 출처: https://ko.wikipedia.org/wiki/XML

---
[Go Docs](https://github.com/MristerWing/PrivateProject/5.MVC/Docs)  