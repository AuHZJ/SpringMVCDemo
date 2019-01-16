package com.briup.web.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/requestParam")
public class RequestParamController {
	
	//����userId�������
	@RequestMapping(value="/test1_1",method=RequestMethod.GET,params="userId")
	public String test1_1() {
		System.out.println("test1 Ҫ��ʹ��Get����");
		return "index";
	}
	
	//����userId�������
	@RequestMapping(value="/test1_2",method=RequestMethod.POST,params="userId")
	public String test1_2() {
		test1_1();
		return "index";
	}
	
	//����userId�����Գ���
	@RequestMapping(value="test2",params="!userId")
	public String test2() {
		return "index";
	}
	
	//����username������֣�������tom
	@RequestMapping(value="/test3",params="username=tom")	
	public String test3() {
		return "index";
	}
	
	//����username���Բ����֣����֣����벻��tom
	@RequestMapping(value="/test4",params="username!=tom")	
	public String test4() {
		return "index";
	}
	
	//�������붼����
	@RequestMapping(value="/test5",params= {"userId","username=tom"})	
	public String test5() {
		return "index";
	}
}
