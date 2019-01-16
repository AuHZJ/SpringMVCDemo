package com.briup.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloWorldController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		//封装数据
		//request session application
		mv.addObject("msg", "hello springMVC ! ! !");
		
		//跳转页面
		//request.getRequestDispatcher("url").forward(request, response);
		//response.sendRedirect("url");
		//设置逻辑视图名
		mv.setViewName("first");
		return mv;
	}

}
