<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP 스크립트 요소</h1>
	
	<!-- HTML 주석 -->
	<%-- JSP 주석 --%>
	


	<%-- 선언문(Declaration) 태그 --%>
	<%!
		private String name = "문인수";
	
		public String getName() {
			return this.name;
		}
	%>
	
	<%-- 스크립트릿(Scriptlet) 태그 --%>
	<%-- 서비스 메소드 내부에 작성이 된다.  --%>
	<%
		int sum = 0;

		for(int i = 1; i <=10; i++){
			sum += i;
			// out.println(sum);
	%>
	<h2>안녕하세요. </h2>
	<%
		}
		System.out.println(sum);
	%>
	
	<%-- 표현식(Expression) 태그 --%>
	저의 이름은 <% out.write(name); %> 입니다.<br>
	저의 이름은 <%= name %> 입니다. <br><br>
	
	1부터 10까지의 합은 <span style="color:red"><% out.print(sum); %></span>입니다. <br>
	1부터 10까지의 합은 <span style="color:blue"><%= sum %></span>입니다. <br>
	
	
</body>
</html>