# Spring_ex9_board


# 1.Project setting

## 1) Encoding
#### a. web.xml EncodingFilter 등록

## 2) API (pom.xml)
#### a. springframework ver 4. 이상
#### b. Mybatis
#### - mybatis
#### - mybatis-spring
#### - spring-jdbc
#### - ojdbc6.jar 
#### c. FileUpload
#### - commons.fileupload (commons-io)
#### d. JunitTest
#### - JUNIT ver 4.12 이상
#### - spring-test

## 3) Junit Test 설정
#### a. src/test/java
#### - 기본 패키지내에서 AbstractTest Junit test case 작성
#### - 클래스 선언 부에
#####	@RunWith(SpringJUnit4ClassRunner.class)
#####	@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
##### - 다른 junit test case 생성해서 상속받아 사용

## 4) XML 파일 설정
#### a. servlet-context.xml

#### b. root-context.xml
##### - mybatis
##### 1) connection - properties 파일 사용	: DriverManagerSource
##### 2) connection xml 				: SqlSessionFactoryBean
##### 3) 최종 Mapping  					: SqlSessionTemplate
##### 4) fileUpload
##### - CommonsMultipartResolver
##### 5) properties 파일 위치 설정
##### - PropertyPlaceholderConfigurer

## 5) Mybatis 설정
#### - file들의 위치
##### src/main/resources 하위에 myBatis 디렉터리 생성
##### config  : mybatis 설정 파일
##### mappers : mybatis sql 파일들



