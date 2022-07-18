package com.kh.mvc.member.comtroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mvc.member.model.vo.Member;

@WebServlet("/member/enroll")
public class EnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EnrollServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 회원가입 페이지로 전환해주는 기능
    	request.getRequestDispatcher("/views/member/enroll.jsp").forward(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	// 멤버 객체 만들기
    	Member member = new Member();
    	
    	member.setId(request.getParameter("userId"));
    	member.setPassword(request.getParameter("userPwd"));
    	member.setName(request.getParameter("userName"));
    	member.setPhone(request.getParameter("phone"));
    	member.setEmail(request.getParameter("email"));
    	member.setAddress(request.getParameter("address"));
    	// 배열로 가져오고 ","로 join 해서 문자열로 주기 
    	member.setHobby(String.join(",", request.getParameterValues("hobby")));
    	
    	System.out.println(member);
	}

}
