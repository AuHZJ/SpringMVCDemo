package com.briup.web.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/requestHeader")
public class RequestHeaderController {

	//请求头必须有 Accept ,才能调用
	@RequestMapping(value="/header/test1_1",headers="Accept")
	public String test1_1() {
		return "index";
	}
	
	
	@RequestMapping(value="/header/test1_2",headers="my_act")
	public String test1_2() {
		return "index";
	}
	
	//必须没有Accept
	@RequestMapping(value="/header/test2",headers="!Accept-Language")
	public String test2() {
		return "index";
	}
	
	
	//请求头数据中指定参数名=值
	@RequestMapping(value="/header/test3", headers="Content-Type=application/json")
	public String test3() {
		return "index";
	}
	
	//请求头数据中指定参数名!=值
	@RequestMapping(value="/header/test4", headers="Accept!=text/plain")
	public String test4() {
		System.out.println("请求头数据中指定参数名Accept!=text/plain");
		return "index";
	}
	
	//组合使用是"且"的关系
	@RequestMapping(value="/header/test5", headers={"Accept!=text/plain", "abc=123"})
	public String test5() {
		return "index";
	}
	
	
	//@RequestMapping(value="/header/test6", consumes="application/json")
	//@RequestMapping(value="/header/test6", produces="application/json")
	@RequestMapping(value="/header/test6",consumes="application/json", produces="application/json")
	public String test6() {
		return "index";
	}
}
