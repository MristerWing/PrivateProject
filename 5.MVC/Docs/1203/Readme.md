# Annotation

1. 세가지 용도
    1. 컴파일러에게 코드 문법 에러를 체크하도록 정보를 제공(ex @Override)
    2. 소프트웨어 개발 툴이 빌드나 배치시 코드를 자동으로 생성할 수 있도록 정보를 제공
    3. 런타임시 특정 기능을 실행 할 수 있도록 정보를 제공
2. 어노테이션 만들기
    1. 타입과 정의 - 타입, 이름 디폴드 값
    2. 적용대상 - ElementType: METHOD, FIELD, CONSTRCTOR, PARAMETER LOCAL_VARIBLE, PACKAGE...
    3. 유지정책: SOURCE, CLASS, RUNTIME
