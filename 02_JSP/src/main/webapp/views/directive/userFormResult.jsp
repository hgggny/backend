<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 스크립트릿(Scriptlet) 태그로 작성
	// POST로 할 경우 별도의 인코딩 과정을 거쳐야 한다. 
	request.setCharacterEncoding("UTF-8");	
	
	// 폼 파라미터 읽어오기
	String userName = request.getParameter("userName");
	String userAge = request.getParameter("userAge");
	String gender = request.getParameter("gender");
	String height = request.getParameter("height");
	String[] food = request.getParameterValues("food");
	
	System.out.println(userName);
	System.out.println(userAge);
	System.out.println(gender);
	System.out.println(height);
	System.out.println(food);
	Arrays.stream(food).forEach(System.out::println);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 응답 결과를 작성 --%> 
	<h2>개인 정보 입력 결과</h2>
	
	<%= userName %>님 안녕하세요 <br>
	<%= userName %>는 <%= userAge %>세 이고 키가 <%= height %>cm인 <%= gender %>입니다.<br>
	좋아하는 음식은 
	<%
		for(String f : food) {

	%>
	<span style="color:red"><%=f + " "%></span>
	
	<%
		} 
	%>
	입니다.
</body>
</html>