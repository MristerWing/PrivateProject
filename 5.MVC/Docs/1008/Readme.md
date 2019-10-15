10/08
===
### 기타사항

1. 도착하면 개발깃 및 서버가 제대로 작동하는지 파악할것
2. 특정한 경우가 아니면 내부사이트의 이동이 더 많다.
3. 외형적인 부분은 CSS에서 작업한다.
4. eclipse의 웹 프로젝트의 resource는 자신의 프로젝트내의 리소스만을 읽을수 있다.
5. 크롬의 디버그 콘솔을 여는 단축키는 Ctrl + Shift + J 이다.
6. html은 틀을 잡아주는 역할을 수행한다. 주로 div와 CSS를 이용한다.
7. 웹은 탑, 컨텐츠, 바텀으로 나누어진다.
8. input의 구조: ```<input type = "종류" name = "식별자명">```
9. HTML의 hidden type은 굉장히 많이 사용한다.
10. 신규 기술은 적용되는 범위, 개선사항 및 얼마나 개선됬는지 알고 변경해야한다.

---
### HTTPS(HyperTextTransferProtocoloverSecureSocketLayer)

* HTTP의 보안이 강화된 버전이다.
* HTTPS는 소켓 통신에서 일반 텍스트 대신에 SSL이나 TLS 프로토콜을 통해 세션 데이터를 암호화한다.
* HTTPS의 기본 포트는 443이다.
* HTTPS의 핵심암호화 원리는 공개키 암호화 방식이다.

>출처1: https://ko.wikipedia.org/wiki/HTTPS  
>출처2: https://jeong-pro.tistory.com/89

### URL(Uniform Resource Locator)

* 네트워크상 자원이 어디있는지 알려주기 위한 규약이다.
* 즉, 컴퓨터 네트워크와 검색 메커니즘에서의 위치를 지정하는 웹리소스에 대한 참조이다.

>출처:https://ko.wikipedia.org/wiki/URL

### URI(Uniform Resource Identifier)

* 인터넷에 있는 자원을 나타내는 유일한 주소이다.
* URI의 존재는 인터넷에서 요구되는 기본조건으로서 인터넷 프로토콜에 항상 붙어 다닌다.
* URL은 URI의 하위 개념이다.
* URI = URL + URN
* **URL과 URI의 차이**: https://blog.lael.be/post/61

>출처: https://ko.wikipedia.org/wiki/%ED%86%B5%ED%95%A9_%EC%9E%90%EC%9B%90_%EC%8B%9D%EB%B3%84%EC%9E%90

### GET & POST

* GET & POST는 HTTP프로토콜을 이용해서 서버에 전송할 때 사용하는 방식이다.
* GET은 주소줄에 값이 ?뒤에 쌍으로 이어붙는다. (ex: ```nidlogin.login?mode=form&url=https%3A%2F%2Fwww.naver.com```)
* POST는 주소줄에 값이 숨겨져서(body안에) 보내진다.
* GET은 가져오는 것이고 POST는 수행하는 것이다.
* **GET: SELECT POST: INSERT & UPDATE**

>출처: **https://blog.outsider.ne.kr/312**

---
[Go Docs](https://github.com/MristerWing/PrivateProject/tree/subDrive/5.MVC/Docs)  