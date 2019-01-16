package com.briup.web.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ViewTestController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//ModelAndView�����������null,Ĭ���û��Զ�����ͼ��ת����
		/*ModelAndView mv = new ModelAndView();
		mv.setViewName("first");*/
		
		
		request.getSession().setAttribute("name", "Tom");
		//�������ڲ���ת
		request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
		//�ͻ����ض���
		//response.sendRedirect("");
		
		//�����ֱ���ڸô�����/������д��Ӧ 
		//����ͨ������null
		//����DispatcherServlet�Լ��Ѿ�д����Ӧ��,
		//����Ҫ��������ͼ����
		PrintWriter out = response.getWriter();
		out.append("hi SpringMVC");
		
		return null;
	}
	
}
