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
	
	
	//1)request和response
	@RequestMapping("a")
	public void testA(HttpServletRequest request,HttpServletResponse response) throws Exception {
		System.out.println("testA");
		//服务器内部跳转
			//跳到页面/视图
			//request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
			//跳到另一个控制器
			//项目名/dispatcher/
			request.getRequestDispatcher("/dispatcher/test").forward(request, response);
		//客户端重定向
			//response.sendRedirect("register");//WEB-INF/jsp/register.jsp
			response.sendRedirect("../dispatcher/test");
		
	}
	
	//2）使用字符串
	@RequestMapping("testB")
	public String testB() {
		System.out.println("testB");
		//return "index";
		//return "forward:index";
		//return "forward:/dispatcher/test";
		//return "redirect:index";
		return "redirect:../dispatcher/test";
	}
	
	//3)使用ModelAndView
	@RequestMapping("/d")
	public ModelAndView testD() throws ServletException, IOException{
		System.out.println("testD");
		
		//服务器内部跳转到另一个功能处理方法
		//ModelAndView mv = new ModelAndView("forward:/dispatcher/b");
		
		//客户端重定向到另一个功能处理方法
		//ModelAndView mv = new ModelAndView("redirect:/dispatcher/b");
		
		//服务器内部跳转到一个页面
		ModelAndView mv = new ModelAndView("index");
		
		return mv;
	}	
	
}
