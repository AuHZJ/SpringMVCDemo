package com.briup.web.annotation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("dispatcher")
public class DispatcherController {
	
	@RequestMapping("test")
	public String test() {
		System.out.println("test");
		return "index";
	}
	
	
	//1)request��response
	@RequestMapping("a")
	public void testA(HttpServletRequest request,HttpServletResponse response) throws Exception {
		System.out.println("testA");
		//�������ڲ���ת
			//����ҳ��/��ͼ
			//request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
			//������һ��������
			//��Ŀ��/dispatcher/
			request.getRequestDispatcher("/dispatcher/test").forward(request, response);
		//�ͻ����ض���
			//response.sendRedirect("register");//WEB-INF/jsp/register.jsp
			response.sendRedirect("../dispatcher/test");
		
	}
	
	//2��ʹ���ַ���
	@RequestMapping("testB")
	public String testB() {
		System.out.println("testB");
		//return "index";
		//return "forward:index";
		//return "forward:/dispatcher/test";
		//return "redirect:index";
		return "redirect:../dispatcher/test";
	}
	
	//3)ʹ��ModelAndView
	@RequestMapping("/d")
	public ModelAndView testD() throws ServletException, IOException{
		System.out.println("testD");
		
		//�������ڲ���ת����һ�����ܴ�����
		//ModelAndView mv = new ModelAndView("forward:/dispatcher/b");
		
		//�ͻ����ض�����һ�����ܴ�����
		//ModelAndView mv = new ModelAndView("redirect:/dispatcher/b");
		
		//�������ڲ���ת��һ��ҳ��
		ModelAndView mv = new ModelAndView("index");
		
		return mv;
	}	
	
}
