package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/method.do")
public class MethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MethodServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 사용자가 보낸 데이터들은 request 객체 안에 키(name 속성의 값), 값(value 속성의 값) 형태로 담겨있다. 
    	// 해당 name 속성을 가지는 요소의 value 값을 문자열로 읽어온다. 
    	String userName = request.getParameter("userName");
    	String userAge = request.getParameter("userAge");
    	String gender = request.getParameter("gender");
    	String height = request.getParameter("height");
    	// 체크박스와 같이 하나의 name 속성에 여러 값이 존재하는 경우 getParameterValues("name 속성") 메소드를 사용한다.
//    	String food = request.getParameter("food");
    	String[] food = request.getParameterValues("food");
    	
    	System.out.println(userName);
    	System.out.println(userAge);
    	System.out.println(gender);
    	System.out.println(height);
    	System.out.println(food);
    	Arrays.stream(food).forEach(System.out::println);
    	
    	// 응답 화면 작성 -> response
    	response.setContentType("text/html;charset=utf-8");
    	
    	PrintWriter out = response.getWriter();
    	
    	out.println("<html>");
    	out.println("<head>");
    	out.println("<title>개인 정보 출력 화면</title>");
    	out.println("</head>");
    	out.println("<body>");
    	out.println("<h2>개인 정보 입력 결과</h2>");
    	out.printf("%s는 %s세 이고 키가 %scm인 %s입니다. \n", userName, userAge, height, gender);
    	out.print("좋아하는 음식은 : ");
    	Arrays.stream(food).forEach(f -> out.write(f + " "));
    	out.print("입니다.");
    	out.println("</body>");
    	out.println("</html>");
    }
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// request에서 파라미터 값을 가져오기 전에 UTF-8로 인코딩 설정을 한다.
    	request.setCharacterEncoding("UTF-8");
    	
    	// 위의 내용과 같아서 아래와 같이 작성해도 되고 똑같이 복사해서 붙여넣기 해도 된다. 
		this.doGet(request, response);
	}
}
