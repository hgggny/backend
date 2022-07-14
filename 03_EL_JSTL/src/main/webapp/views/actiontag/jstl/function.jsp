<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Function Library</title>
</head>
<body>
	<h1>JSTL Function Library</h1>
	
	<c:set var="str" value="java orcle HTML CSS Javascript jQuery Servlet JSP"/>
	
	원본 : ${ str }<br>
	
	<!-- 
	이렇게 사용했었다
	<%
		String str = (String) pageContext.getAttribute("str");
	%>
	문자열 길이 : <%= str.length() %>
	 -->
	
	문자열 길이 : ${ fn:length(str) } <br>
	대문자로 변경 : ${ fn:toUpperCase(str) } <br>
	소문자로 변경 : ${ fn:toLowerCase(str) } <br>
	<!-- toUpperCase와 toLowerCase는 원본에 영향을 주지 않는다.  -->
	원본 : ${ str }<br>
	CSS의 위치는 : ${ fn:indexOf(str, "CSS") }<br>
	JSP를 JSTL로 변경 : ${ fn:replace(str, "JSP", "JSTL") }
	
</body>
</html>