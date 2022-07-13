<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp:include 액션 태그</title>
</head>
<body>
	<h1>jsp:include 액션 태그</h1>
	<p>
		현재 JSP 페이지에 다른 페이지를 포함하고자 할 때 사용하는 액션 태그이다.
	</p>
	
	<h2>1. include 지시자 (정적 include 방식)</h2>
	<p>
		다른 페이지를 포함하는 JSP 파일이 컴파일 되기 전에 페이지에 삽입된다. 
		자바 코드로 변경되는 과정에서 포함되는 페이지의 내용이 자바 코드로 복사(포함)돼서 들어간다. 
	</p>
	<%--
	<%@ include file = "includePage.jsp" %>
	
	
	Include 한 페이지의 선언한 변수를 사용할 수 있다. 
	Include 한 페이지의 year 변수 값은 <%= year %> 입니다. <br>
	
	현재 페이지와 포함된 페이지인 includePage.jsp에 변수명이 중복되어 에러(Duplicate local variable) 발생 
	<%
		String year ="2023";
	%>
	--%>
	
	<h2>2. include 액션 태그 (동적 include 방식)</h2>
	<p>
		다른 페이지를 포함하는 JSP 파일이 화면에 출력되는 시점(런타임)에 삽입된다.
		소스 코드를 복사하는게 아니도 제어권 자체가 넘어갔다가 페이지가 끝나면 다시 돌아와서 이 후 내용이 출력된다. 
	</p>
	<jsp:include page="includePage.jsp"/>
	
	<%
		String year ="2023";
	%>
	
	include:jsp 페이지의 year 변수 값은 <%= year %> 입니다. <br>
	
	<!-- jsp:param 액션 태그를 이용해서 포함되는 페이지로 값을 전달할 수 있다.  -->
	<jsp:include page="includePage.jsp">
		<jsp:param name="userName" value="문인수"/>
	</jsp:include>
</body>
</html>