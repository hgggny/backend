package com.kh.mvc.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import com.kh.mvc.common.wrapper.EncryptPasswordWrapper;

// servletNames = {"EnrollServlet", "LoginServlet"} - 서블릿이 실행되기 전에 실행될 것이다. 
@WebFilter(filterName = "encrypt", servletNames = {"enroll", "login"})
public class EncryptFilter extends HttpFilter implements Filter {
       
    public EncryptFilter() {
    }

    @Override
	public void destroy() {
	}

    @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	// request 객체의 파라미터 값을 직접 변경할 수 없기 때문에 래퍼 클래스를 생성해서 파라미터 값을 수정
    	EncryptPasswordWrapper wrapper = new EncryptPasswordWrapper((HttpServletRequest)request);
    	
    	
    	// request를 직접 재정의 할 수 없기 때문에 wrapper 라는 객체로 재정의해서 넘겨준다. 
		chain.doFilter(wrapper, response);
	}

    @Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
