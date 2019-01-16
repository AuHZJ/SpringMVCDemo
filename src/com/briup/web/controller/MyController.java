package com.briup.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public class MyController {

	
	public ModelAndView myTest() {
			
			ModelAndView modelAndView = new ModelAndView("index");
			
			return modelAndView;
	}
	
	public ModelAndView myTest(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("index");
		
		return modelAndView;
	}
	
	public ModelAndView myTest(HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView modelAndView = new ModelAndView("first");
		
		return modelAndView;
	}
}
