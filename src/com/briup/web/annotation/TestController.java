package com.briup.web.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class TestController {
	@RequestMapping("test1")
	public String test1() {
		return "first";
	}
	
	@RequestMapping("test2")
	public void test2() {
		
		
	}
	
	@RequestMapping("aa")
	public void test3() {
		
		
	}
}
