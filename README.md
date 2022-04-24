# 통합 웹게임 사이트 - 헤헤 (관리자 페이지)

### 조원
+ 권진용(팀장)
+ 김무진
+ 유승현
+ 한영인
--------
### 의존성
+ devtools (Spring)
```
developmentOnly 'org.springframework.boot:spring-boot-devtools'
testImplementation 'org.springframework.boot:spring-boot-starter-test'
```
+ spring web (mvc)
```
implementation 'org.springframework.boot:spring-boot-starter-web'
```
+ mustache (view)
```
implementation 'org.springframework.boot:spring-boot-starter-mustache'
```
+ lombok
```
compileOnly 'org.projectlombok:lombok'
annotationProcessor 'org.projectlombok:lombok'
```
+ JPA (DB 접근)
```
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
```
+ mysqldb or mariadb (DB)
```
runtimeOnly 'org.mariadb.jdbc:mariadb-java-client'
runtimeOnly 'mysql:mysql-connector-java'
```
+ validation (yml 자기가 만든변수 가져오기)
```
implementation 'org.springframework.boot:spring-boot-starter-validation'
```
--------
### 활용기술
<div>
    <img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=SpringBoot&logoColor=white">
    <img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=Java&logoColor=white">
    <img src="https://img.shields.io/badge/JavaScript-3F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=white">
</div>
<div>
    <img src="https://img.shields.io/badge/Bootstrap-7952B3?style=for-the-badge&logo=Bootstrap&logoColor=white">
    <img src="https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=MariaDB&logoColor=white">
    <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white">
</div>

---------

### 페이지
+ 메인
  + 로그인
  + 회원가입
  + 게임 관리
    + 게임 목록
    + 새로운 게임 등록
  + 사용자 관리
    + 사용자 정보
  + 답변하기
    + 질문 목록보기
    + 질문 상세보기
    + 질문 답변하기
    
---------

|기능|활용기술|활용페이지|샘플링크|
|---|----|-----|----|
|유효성검사|JPA|회원가입|[블로그버전2](https://github.com/jinyongkwon/BlogProject-V2)|
|중복확인|JPA|회원가입, 로그인, 아이디찾기, 비밀번호찾기|[블로그버전2](https://github.com/jinyongkwon/BlogProject-V2)|
|사진등록및 확인|JPA|회원가입, 로그인, 아이디찾기, 비밀번호찾기|[파일업로드샘플깃](https://github.com/jinyongkwon/Spring-Fileupload-sample), [블로그버전3](https://github.com/jinyongkwon/BlogProject-V3)|
-------
### DB모델링및 관계
- id, nickname, username, password , email , coin ,createDate, updateDate, rpgId => user
- id, title, content, file, createDate, updateDate, userId => question
- id, content, createDate, questionId, userId => comment
- id, name, image, url => game
- id, createDate, email, password, updateDate, username => manager
-------
