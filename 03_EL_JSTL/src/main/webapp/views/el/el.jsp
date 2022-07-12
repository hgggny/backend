<%@page import="com.kh.el.model.vo.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	// 1. 기존 방식으로 request, session 객체에 담겨있는 데이터를 출력
	// getAttribute 리턴해주는 값이 Object 타입이므로 String과 Student로 형변환을 해야한다. 
	
	// Request 영역에 저장된 속성(Attribute)를 가져온다.
	// String classRoom = (String) request.getAttribute("classRoom");
	// Student student = (Student) request.getAttribute("student");
	
	// Session 영역에 저장된 속성(Attribute)를 가져온다.
	// String classRoom = (String) session.getAttribute("classRoom");
	// Student student = (Student) session.getAttribute("student");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL(Expression Language)</title>
</head>
<body>
	<h1>EL(Expression Language)</h1>
	
	<%-- // 표현식 태그로 데이터 출력 --%>
	<h2>1. 기존 방식으로 request, session 객체에 담겨있는 데이터를 출력</h2>
	<%-- 
	강의장 : <%= classRoom %> <br>
	수강생 : <%= student.getName() %>, <%= student.getAge() %>
	 --%>
	
	<h2>2. EL 방식으로 request, session 객체에 담겨있는 데이터를 출력</h2>
	<%-- 
		1. EL은 영역 객체에 저장된 속성명(Attribute)을 검색해서 존재하는 경우 값을 가져온다.
			- Page 영역 -> Request 영역 -> Session 영역 -> Application 영역 순으로 해당 속성을 찾아서 값을 가져온다. 
			
		2. EL은 객체의 필드에 직접 접근하는 것 처럼 보이지만 내부적으로는 해당 객체의 Getter 메소드로 접근해서 값을 읽어온다. 
	 --%>
	강의장 : ${ classRoom } <br>
	수강생 : ${ student.name }, ${ student.age} <br>
	
	<h2>3. EL 사용 시 내장 객체에 저장된 속성명이 같은 경우</h2>
	<%
		pageContext.setAttribute("scope", "page");
	%>
	<!-- 여러 영역에 동일한 속성명을 가지는 데이터를 저장했다면, 명시적으로 영역(스코프)를 지정해서 원하는 영역의 속성값을 읽어올 수 있다.  -->
	scope: ${ scope } <br>
	requestScope : ${ requestScope.scope } <br>
	sessionScope : ${ sessionScope.scope } <br>
	applicationScope : ${ applicationScope.scope } <br>
	
	<h2>4. ContextPath 가져오기</h2>
	<h3>1) 표현식 태그를 사용하는 방법</h3>
	ContextPath : <%= request.getContextPath() %>

	<h3>2) EL을 사용하는 방법</h3>
	ContextPath : ${ pageContext.request.contextPath }
	
	<h2>5. 헤더에 접근하기</h2>
	<h3>1) 표현식 태그를 사용하는 방법</h3>
	Host : <%= request.getHeader("host") %> <br>
	User-Agent : <%= request.getHeader("User-Agent") %>
	
	<h3>2) EL을 사용하는 방법</h3>
	Host : ${ header.host } <br>
	User-Agent : ${ header['User-Agent'] }
</body>
</html>