package com.kh.el.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.el.model.vo.Student;

@WebServlet("/el.do")
public class ELServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ELServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	ServletContext application = request.getServletContext();
    	
    	// Request 영역에 데이터를 저장
    	request.setAttribute("classRoom", "C 강의장");
    	request.setAttribute("student", new Student("홍길동", 20, 80, 80));
    	request.setAttribute("scope", "request");
    	
    	// Session 영역에 데이터를 저장
    	session.setAttribute("classRoom", "D 강의장");
    	session.setAttribute("student", new Student("성춘향", 18, 100, 100));
    	session.setAttribute("scope", "session");

    	// Application 영역에 데이터를 저장
    	application.setAttribute("academy", "KH 정보교육원");
    	application.setAttribute("teacher", "문인수");
    	application.setAttribute("scope", "application");
    	
    	// request에서 forward 하는 방법
    	// RequestDispatcher라는 객체를 얻어와서 String path로 forward 하기
    	request.getRequestDispatcher("views/el/el.jsp").forward(request, response);
    }
}
