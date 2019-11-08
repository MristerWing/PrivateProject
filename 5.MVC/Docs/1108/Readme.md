11/08
===
### myBatis connectPool setup
#### 1. SqlMapConfig.xml 설정파일 직접 설정법

1. myBatis홈페이지 접속 => 매퍼설정 => environments(자세한 내용에 대해서 전부 설명되어있음)
2. POOLED => SqlMapConfig.xml을 설정해야함

#### 2. 서버의 context설정법을 가져와 설정하는 방법 

1. environments까지는 동일. => JNDI => SqlMapConfig =>  
2. ```<dataSource type="JNDI">```로 변경 => ```<property>```태그 전부 지훈후 
3. ```<property name="initial_context" value="java:/comp/env"/>```  
```<property name="data_source" value="jdbc/mvcDB"/>``` 로 변경  
4. initial_context: 서버에 등록한 식별자  
5. data_source: 서버 context.xml에 등록한 Resource 식별자  
* 예)  

``````````````````````````` 
<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
  <environments default="development">
    <environment id="development">
      <transactionManager type="JDBC"/>
      <dataSource type="JNDI">
        <property name="initial_context" value="java:/comp/env"/>
        <property name="data_source" value="jdbc/mvcDB"/>
      </dataSource>
    </environment>
  </environments>
  <mappers>
    <mapper resource="com/java/member/dao/MemberMapper.xml"/>
    <mapper resource="com/java/board/dao/BoardMapper.xml"/>
    <mapper resource="com/java/guest/dao/GuestMapper.xml"/>
    <mapper resource="com/java/fileboard/dao/FileboardMapper.xml"/>
  </mappers>
</configuration> 
`````````````````````````````````````````

내용은 설정에 따라서 어느정도 다를 수 있음.

----
### DOM

1. The Document Object Model. 웹에서 동적(페이지와 페이지간의 이동)이 아닌 
정적(페이지 내에서 애니메이션의 변환)을 처리하는데 사용한다.
2. DOM은 4가지로 값을 가져올 수 있다.
    * id부여, name식별자 사용, class이름으로 가져옴, tag명칭으로 가져옴
3. DOM에서 checkbox하고 radio는 id 못쓴다.

---

[Go Docs](https://github.com/MristerWing/PrivateProject/tree/master/5.MVC/Docs)