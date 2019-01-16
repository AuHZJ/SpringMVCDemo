package com.briup.web.annotation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.User;

@Controller
@RequestMapping("/request_body_param")
//����ControllerΪ�ǵ�������
@Scope("prototype")
public class RequestBodyAndResponseBodyParamController {
	
	public RequestBodyAndResponseBodyParamController() {
		//System.out.println("this:"+this);
	}
	
	//id=101&name=zs&age=18
	@RequestMapping("/test1")
	public void test1(@RequestBody String param,HttpServletResponse response) throws Exception {
		System.out.println("param:"+param);
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("hello SpringMVC ajax�첽����");
	}
	//id=101&name=zs&age=18
	@RequestMapping("/test2")
	public void test2(@RequestParam String id,@RequestParam String name,@RequestParam String age,HttpServletResponse response) throws Exception {
		System.out.println("id:"+id);
		System.out.println("name:"+name);
		System.out.println("age:"+age);
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("hello SpringMVC ajax�첽����");
	}
	
	@RequestMapping(value="/test3",consumes="application/json",produces="application/json")
	public void test3(@RequestBody User user,HttpServletResponse response) throws Exception {
		System.out.println("user:"+user);
		
		response.setContentType("text/html;charset=utf-8");
		//response.getWriter().write("hello SpringMVC ajax�첽����");
		response.getWriter().write("{\"msg\":\"hello SpringMVC ajax�첽���� \"}");
	
	}
	
	@RequestMapping(value="/test4",consumes="application/json",produces="application/json")
	//��ǰ���������ڷ�����ͼ��������Ӧ��
	@ResponseBody
	public String test4(@RequestBody User user,HttpServletResponse response) throws Exception {
		System.out.println("user:"+user);
		return "hello SpringMVC ajax�첽����";
	}
		
	@RequestMapping(value="/test5",consumes="application/json",produces="application/json")
	//��ǰ���������ڷ�����ͼ��������Ӧ��
	@ResponseBody
	public User test5(@RequestBody User user,HttpServletResponse response) throws Exception {
		System.out.println("user:"+user);
		return user;
	}
	
	@RequestMapping(value="/test6",consumes="application/json",produces="application/json")
	//��ǰ���������ڷ�����ͼ��������Ӧ��
	@ResponseBody
	public User[] test6(@RequestBody User user,HttpServletResponse response) throws Exception {
		System.out.println("user:"+user);
		User[] us = new User[3];
		us[0]=new User(1001L,"����",18);
		us[1]=new User(1002L,"���޼�",18);
		us[2]=new User(1003L,"����",18);
		
		return us;
	}
	
	@RequestMapping(value="/test7",consumes="application/json",produces="application/json")
	//��ǰ���������ڷ�����ͼ��������Ӧ��
	@ResponseBody
	public List<User> test7(@RequestBody User user,HttpServletResponse response) throws Exception {
		System.out.println("user:"+user);
		//�������϶���
		List<User> list = new ArrayList<>();
		//����bean����
		User u1 = new User(1001L,"����",18);
		User u2 = new User(1002L,"���޼�",18);
		User u3 = new User(1003L,"����",18);
		//������뼯������
		list.add(u1);
		list.add(u2);
		list.add(u3);
		
		return list;
	}
	
	@RequestMapping(value="/test8",consumes="application/json",produces="application/json")
	//��ǰ���������ڷ�����ͼ��������Ӧ��
	@ResponseBody
	public Map<String,User> test8(@RequestBody User user,HttpServletResponse response) throws Exception {
		System.out.println("user:"+user);
		//�������϶���
		Map<String,User> map = new HashMap<>();
		//����bean����
		User u1 = new User(1001L,"����",18);
		User u2 = new User(1002L,"���޼�",18);
		User u3 = new User(1003L,"����",18);
		//������뼯������
		map.put(u1.getName(), u1);
		map.put(u2.getName(), u2);
		map.put(u3.getName(), u3);
		
		return map;
	}
}
