package com.kh.mvc.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mvc.board.model.service.BoardService;
import com.kh.mvc.board.model.vo.Board;
import com.kh.mvc.common.util.PageInfo;

@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int page = 0;
    	int listCount = 0;
    	PageInfo pageInfo = null;
    	List<Board> list = null;

    	// page 값이 없으면 예외처리로 page 번호를 1로 처리
    	try {
    	page = Integer.parseInt(request.getParameter("page"));
    	} catch (NumberFormatException e) {
    		page = 1;
    	}
     	
    	listCount = new BoardService().getBoardCount();
    	pageInfo = new PageInfo(page, 10, listCount, 10);
    	list = new BoardService().getBoardList(pageInfo);
    	
    	System.out.println(list);
    	
    	request.setAttribute("pageInfo", pageInfo);
    	
    	request.getRequestDispatcher("/views/board/list.jsp").forward(request, response);
	}

}
