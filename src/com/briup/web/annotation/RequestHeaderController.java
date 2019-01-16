package com.briup.web.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/requestHeader")
public class RequestHeaderController {

	//����ͷ������ Accept ,���ܵ���
	@RequestMapping(value="/header/test1_1",headers="Accept")
	public String test1_1() {
		return "index";
	}
	
	
	@RequestMapping(value="/header/test1_2",headers="my_act")
	public String test1_2() {
		return "index";
	}
	
	//����û��Accept
	@RequestMapping(value="/header/test2",headers="!Accept-Language")
	public String test2() {
		return "index";
	}
	
	
	//����ͷ������ָ��������=ֵ
	@RequestMapping(value="/header/test3", headers="Content-Type=application/json")
	public String test3() {
		return "index";
	}
	
	//����ͷ������ָ��������!=ֵ
	@RequestMapping(value="/header/test4", headers="Accept!=text/plain")
	public String test4() {
		System.out.println("����ͷ������ָ��������Accept!=text/plain");
		return "index";
	}
	
	//���ʹ����"��"�Ĺ�ϵ
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
