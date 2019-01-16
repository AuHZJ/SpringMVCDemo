package com.briup.web.annotation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller只是确定当前类是控制器
@Controller
@RequestMapping("/hello")
public class HelloController {
	//@RequestMapping请求映射
	//@RequestMapping("/test1") 
	//@RequestMapping(value="test1") 
	@RequestMapping(value= {"/test1","/t","/index"}) 
	public ModelAndView test1() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	
	@RequestMapping("/test2")
	public ModelAndView test2(HttpServletRequest request,HttpServletResponse response) {
		try {
			request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request,response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping("/test3")
	public String test3() {
		return "index";
	}
	
	@RequestMapping("/test4")
	public void test4(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().write("hello Spring anotation "+username);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
