package com.briup.web.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ViewTestController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//ModelAndView对象，如果返回null,默认用户自定义视图跳转问题
		/*ModelAndView mv = new ModelAndView();
		mv.setViewName("first");*/
		
		
		request.getSession().setAttribute("name", "Tom");
		//服务器内部跳转
		request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
		//客户端重定向
		//response.sendRedirect("");
		
		//如果想直接在该处理器/控制器写响应 
		//可以通过返回null
		//告诉DispatcherServlet自己已经写出响应了,
		//不需要它进行视图解析
		PrintWriter out = response.getWriter();
		out.append("hi SpringMVC");
		
		return null;
	}
	
}
