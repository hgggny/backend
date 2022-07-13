<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");

	String year = "2022";
	// String userName = request.getParameter("userName");
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Include 페이지</h2>
	
	includePage.jsp 페이지의 year 변수 값은 <%= year %> 입니다. <br><br>
	
	<%--
	userName : <%= userName %>
	 --%>
	userName : ${ param.userName } <br>
</body>
</html>