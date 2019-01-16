package com.briup.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		Object obj = session.getAttribute("user");
		
		if (session == null || obj==null ) {
			
			request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
			
			return false;
		}
		//返回对应请求
		return true;
	}
	
}
