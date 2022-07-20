package com.kh.mvc.member.comtroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.mvc.member.model.service.MemberService;
import com.kh.mvc.member.model.vo.Member;

@WebServlet("/member/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateServlet() {
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 1. 로그인 된 사용자인지 체크
    	int result = 0;
    	HttpSession session = request.getSession(false);
    	Member loginMember = (session == null) ? null : (Member) session.getAttribute("loginMember");
    	
    	if (loginMember != null ) {
        	// 2. 사용자가 수정한 내용을 가지고 Member 객체를 생성
        	Member member = new Member();
        	
        	// 로그인한 멤버의 FK 값을 가져온다. 
        	member.setNo(loginMember.getNo());
//        	member.setNo(request.getParameter("userNo"));
        	member.setId(request.getParameter("userId"));
        	member.setName(request.getParameter("userName"));
        	member.setPhone(request.getParameter("phone"));
        	member.setEmail(request.getParameter("email"));
        	member.setAddress(request.getParameter("address"));
        	member.setHobby(String.join(",", request.getParameterValues("hobby")));
        	
        	// save : 수정하거나 저장
        	result = new MemberService().save(member);
        	
        	if (result > 0) {
        		// 회원 정보 수정 성공
        		// 세션 갱신한다.
        		session.setAttribute("loginMember", new MemberService().findMemberById(loginMember.getId()));
        		
        		request.setAttribute("msg", "회원 정보 수정 완료");
    			request.setAttribute("location", "/member/myPage");
        	} else {
        		// 회원 정보 수정 실패
        		request.setAttribute("msg", "회원 정보 수정 실패");
    			request.setAttribute("location", "/member/myPage");
        	} 
    	} else {
    		request.setAttribute("msg", "로그인 후 수정해 주세요.");
			request.setAttribute("location", "/");
			
    	}
    	request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
   }
}
