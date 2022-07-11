<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- redirect 라서 응답 HTML 모두 필요없다. --%>
<%
	response.sendRedirect("redirect_target.jsp");
%>