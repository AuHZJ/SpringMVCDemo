package com.briup.web.adapter;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

public class MyHandlerAdapter implements HandlerAdapter {
	Object handler;
	Method method;
	
	
	//验证Object handler是否 是控制器
	@Override
	public boolean supports(Object handler) {
		//反射
		try {
			method = 
					handler.getClass()// Object--->Class
					.getMethod(		 //  Class.getMethod()
								"myTest",
								 new Class[] {
									HttpServletRequest.class,
									HttpServletResponse.class
								 }
							);
			if (method!=null) {
				this.handler=handler;
				return true;
			}
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return false;
	}

	//如果是控制器，执行对应方法
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return (ModelAndView) method.invoke(handler, new Object[] {request,response});
	}

	@Override
	public long getLastModified(HttpServletRequest request, Object handler) {
		return -1L;
	}

}
