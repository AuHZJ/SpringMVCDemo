package com.briup.web.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/URL")
public class URLController {
	//@RequestMapping("/test1") 
	//@RequestMapping(value="test1") 
	@RequestMapping(value= {"/test1","/t","/index"}) 
	public String test1() {
		return "index";
	}
	
	// test2/userId=123
	//@RequestMapping(value="/test2/{userId}")
	//@RequestMapping(value="/test2/{userId}/a/b") 
	//@RequestMapping(value="/user/{userId}/topics/{topicId}")
	public String test2() {
		return "index";
	}
	
	//ant风格 /** /* ？
	//@RequestMapping("/user/*")
	//@RequestMapping("/user/**")
	//@RequestMapping("/user/?")
	//@RequestMapping("/user?")
	//@RequestMapping("/user*")
	//@RequestMapping(value="/user/*/{userId}")
	//@RequestMapping(value="/user/**/{userId}")
	public String test3() {
		return "index";
	}
	
	//@RequestMapping(value="/user/{key:正则表达式}")
	//@RequestMapping(value="/user/{userid:\\d+}")
	@RequestMapping(value="/user/{userId:^\\d{4}-[a-z]{2}$}")
	public String test4() {
		return "index";
	}
}
