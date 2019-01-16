package com.briup.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloWorldController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		//��װ����
		//request session application
		mv.addObject("msg", "hello springMVC ! ! !");
		
		//��תҳ��
		//request.getRequestDispatcher("url").forward(request, response);
		//response.sendRedirect("url");
		//�����߼���ͼ��
		mv.setViewName("first");
		return mv;
	}

}
