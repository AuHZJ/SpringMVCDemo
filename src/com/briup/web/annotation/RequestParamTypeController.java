package com.briup.web.annotation;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.User;

@Controller
@RequestMapping("/request_param_type")
public class RequestParamTypeController {
	
	//1)�����ǻ�����������/��װ����/String
	@RequestMapping("/test1")
	@ResponseBody
	public String test1(@RequestBody String param,HttpServletResponse response) throws Exception {
		System.out.println("param:"+param);
		
		return "hello SpringMVC";
	}
	//2)��������������
	@RequestMapping("/test2")
	@ResponseBody
	public String test2(@RequestBody String[] param,HttpServletResponse response) throws Exception {
		for (String s : param) {
			System.out.println(s);
		}
		return "hello SpringMVC";
	}
	
	//3)������������(����ʵ����Uesr��Student��)
	//POST��ȡ������װ�ɶ���
		//1.contentType:"application/json",
		//  JSON.stringify(json)
	@RequestMapping("/test3_1")
	@ResponseBody
	public String test3_1(@RequestBody User user,HttpServletResponse response) throws Exception {
		System.out.println(user);
		return "hello SpringMVC";
	}
	
	//3)������������(����ʵ����Uesr��Student��)
	//GET
		//contentType:"application/x-www-form-urlencoded",
		//"id=101&name=zs&age=22&dob=2018-11-19"
	@RequestMapping("/test3_2")
	@ResponseBody
	public String test3_2(User user,HttpServletResponse response) throws Exception {
		System.out.println(user);
		return "hello SpringMVC";
	}
	
	//4)�����������͵�����
	@RequestMapping("/test4")
	@ResponseBody
	public String test4(@RequestBody User[] user,HttpServletResponse response) throws Exception {
		
		for (User u : user) {
			System.out.println(u);
		}
		return "hello SpringMVC";
	}
	
	//5)List/Set����
	@RequestMapping("/test5")
	@ResponseBody
	public String test5(@RequestBody List<User> user,HttpServletResponse response) throws Exception {
		
		for (User u : user) {
			System.out.println(u);
		}
		return "hello SpringMVC";
	}
	
	//6)Map����
	@RequestMapping("/test6")
	@ResponseBody
	public String test6(@RequestBody Map<String,User> map,HttpServletResponse response) throws Exception {
		
		for (String name : map.keySet()) {
			System.out.println(name+": "+map.get(name));
		}
		return "hello SpringMVC";
	}
}
