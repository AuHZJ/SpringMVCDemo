package com.briup.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TimeMyInterceptor  extends HandlerInterceptorAdapter{

	ThreadLocal<Long> tl = new ThreadLocal<>();;
	
	/**
	 * ��ʼ����
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("MyInterceptor2 preHandle");
		//long time = new Date().getTime();
		long start = System.currentTimeMillis();
		tl.set(start);
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("MyInterceptor2 postHandle()!!! ");
	}
	
	/**
	 * ���ý���
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long end = System.currentTimeMillis();
		Long start = tl.get();
		System.out.println("����ʱ��"+(end - start)+" ����");
		System.out.println("MyInterceptor2 afterCompletion!!!");
	}
}
