package com.briup.web.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/requestParam")
public class RequestParamController {
	
	//参数userId必须出现
	@RequestMapping(value="/test1_1",method=RequestMethod.GET,params="userId")
	public String test1_1() {
		System.out.println("test1 要求使用Get请求");
		return "index";
	}
	
	//参数userId必须出现
	@RequestMapping(value="/test1_2",method=RequestMethod.POST,params="userId")
	public String test1_2() {
		test1_1();
		return "index";
	}
	
	//参数userId不可以出现
	@RequestMapping(value="test2",params="!userId")
	public String test2() {
		return "index";
	}
	
	//参数username必须出现，必须是tom
	@RequestMapping(value="/test3",params="username=tom")	
	public String test3() {
		return "index";
	}
	
	//参数username可以不出现，出现，必须不是tom
	@RequestMapping(value="/test4",params="username!=tom")	
	public String test4() {
		return "index";
	}
	
	//参数必须都出现
	@RequestMapping(value="/test5",params= {"userId","username=tom"})	
	public String test5() {
		return "index";
	}
}
