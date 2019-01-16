package com.briup.web.annotation;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.briup.bean.User;

@Controller
@RequestMapping("/request_param_bind")
@SessionAttributes(value={"user"})
public class RequestParamBindController {

	//SpringMVCĬ���ǻ���ݲ�����ȥ��������
	@RequestMapping("/test1_1")
	public String test1_1(String username) {
		System.out.println("username = "+username);
		return "index";
	}
	
	@RequestMapping("/test1_2")
	public String test1_2(@RequestParam("name") String username) {
		System.out.println("username = "+username);
		return "index";
	}
	
	@RequestMapping("/test1_3")
	public String test1_3(@RequestParam("username") String username) {
		System.out.println("username = "+username);
		return "index";
	}
	
	//required Ĭ����true.��˼�ǲ������봫�����򱨴�
	@RequestMapping("/test1_4")
	public String test1_4(@RequestParam(value="name",required=false) String username) {
		System.out.println("username = "+username);
		return "index";
	}
	
	
	@RequestMapping("/test1_5")
	public String test1_5(@RequestParam(value="name",required=false,defaultValue="Tom") String username) {
		System.out.println("username = "+username);
		return "index";
	}
	
	//SPEL���ʽ #{name}
	@RequestMapping("/test1_6")
	//public String test1_6(@RequestParam(value="name",required=false,defaultValue="#{systemProperties['java.vm.version']}") String username) {
	public String test1_6(@RequestParam(value="name",required=false,defaultValue="#{systemProperties['sun.desktop']}") String username) {
		System.out.println("username = "+username);
		return "index";
	}
	
	@RequestMapping("/test1_7")
	public String test1_7(@RequestParam(value="name",required=false,defaultValue="#{util.name}") String username) {
		System.out.println("username = "+username);
		return "index";
	}
	
	@RequestMapping("/test1_8")
	//public String test1_8(@RequestParam(value="name",required=false,defaultValue="#{util.sayHello()}") String username) {
	//public String test1_8(@RequestParam(value="name",required=false,defaultValue="#{util.sayHello('SPEL')}") String username) {
	//public String test1_8(@RequestParam(value="name",required=false,defaultValue="#{util.data()}") String username) {
	public String test1_8(@RequestParam(value="name",required=false,defaultValue="#{util.now()}") String username) {
		System.out.println("username = "+username);
		return "index";
	}
	
	@RequestMapping("/test1_9")
	public String test1_9(@RequestParam(defaultValue="#{util.sayHello('SPEL').toUpperCase()}") String username) {
		System.out.println("username = "+username);
		//String str = "helloSPEL";
		//str.toUpperCase();
		return "index";
	}
	
	//?�������ǰ���ֵΪnull,�򲻼�������ִ��
	@RequestMapping("/test1_10")
	public String test1_10(@RequestParam(defaultValue="#{util.sayHello4Null()?.toUpperCase()}") String username) {
		System.out.println("username = "+username);
		//String str = "helloSPEL";
		//str.toUpperCase();
		return "index";
	}
	
	//������Ҫ�����ⲿ���
	//ʹ��T(�ⲿ�����).����()
	@RequestMapping("/test1_11")
	public String test1_11(@RequestParam(defaultValue="#{T(java.lang.Math).random()}") String username) {
		System.out.println("username = "+username);
		//String str = "helloSPEL";
		//str.toUpperCase();
		return "index";
	}
	
	@RequestMapping("/test2_1")
	public String test2_1(String username,Model m) {
		System.out.println("test2 username = "+username);
		//�����ݴ���Model
		m.addAttribute("username", username);
		return "index";
	}
	
	//@PathVariable�����ݷŵ�Model����
	@RequestMapping("/test3_2/{name}")
	public String test2_2(@PathVariable("name") String username) {
		System.out.println("test2 username = "+username);
		//m.addAttribute("name", username);
		return "index";
	}
	
	@RequestMapping("/test3_3/{username}/and/{password}")
	public String test2_3(@PathVariable String username,@PathVariable String password) {
		System.out.println("test2 username = "+username+" password= "+password);
		
		return "index";
	}
	
	//Cookie: JSESSIONID=EA1DDF3B207791EC2E5175F36EE69138
	//       sessionId = EA1DDF3B207791EC2E5175F36EE69138
	@RequestMapping("/test4")
	public String test(@CookieValue(value="username",defaultValue="") String sessionId) {
		System.out.println("sessionId = "+sessionId);
		return "index";
	}
	
	
	//@RequestHeader��ȡrequest����Ĳ�����key:value ��װ����������
	@RequestMapping(value="/test5")
	public String test(
			@RequestHeader("User-Agent") String userAgent,
			@RequestHeader(value="Accept") String[] accepts,
			@RequestHeader("Cookie") String jsessionId,
			@RequestHeader("Host") String host
			
			) {
		
		System.out.println(userAgent);
		for (String key : accepts) {
			System.out.println(key);
		}
		System.out.println(jsessionId);
		System.out.println(host);
		
		return "index";
	}
	

	//@ModelAttribute ���������������/������
	//----> �����ݴ���Model
	//http://127.0.0.1/SpringMVC_Demo/request_param_bind/test6?id=101&name=zs&age=18
	@RequestMapping("/test6")
	public String test6(User user) {
		System.out.println(user);
		return "index";
	}
	
	
	@RequestMapping("/test6_2")
	public String test6_2(@ModelAttribute("user") User user) {
		//Ĭ�ϰ����ݴ���ģ�ͣ�ʹ�� ��������ĸСд��ģʽ user
		System.out.println(user);
		//m.addObject("user",user);
		return "index";
	}
	
	@RequestMapping("/test6_3")
	public String test6_3(@ModelAttribute("user") User u) {
		//Ĭ�ϰ����ݴ���ģ�ͣ�ʹ�� ��������ĸСд��ģʽ user
		System.out.println(u);
	//	m.addAttribute("user", u);
		return "index";
	}
	
	@RequestMapping("/test6_4")
	public String test6_4(@ModelAttribute("u") User user) {
		//Ĭ�ϰ����ݴ���ģ�ͣ�ʹ�� ��������ĸСд��ģʽ user
		System.out.println(user);
	//	m.addAttribute("u", user);
		return "index";
	}
	
	//����һ����ͨ����,	
	//ʹ��@ModelAttribute("key"),�ڹ��ܴ�����ִ��ǰ,��ģ����������ݣ����ѷ���ֵ����Model
	//Model.addObject(key,getUser());
	@ModelAttribute("user")
	public User getUser() {
		System.out.println("in getUser");
		User user = new User(10086L, "�й��ƶ�", 20);
		return user;
	}
	
	@RequestMapping("/test6_5")
	public String test6_5(@ModelAttribute("user") User user) {
		//Ĭ�ϰ����ݴ���ģ�ͣ�ʹ�� ��������ĸСд��ģʽ user
		System.out.println(user);
	//	m.addAttribute("user", user);
		return "index";
	}
	
	@RequestMapping("/test7_1")
	public String test7_1(@ModelAttribute("user") User user,HttpSession session) {
		
		session.setAttribute("key", "value");
		
		System.out.println("session.getAttribute(\"user\") = "+session.getAttribute("user"));
		System.out.println(session.getAttribute("key"));
		return "index";
	}
	
	@RequestMapping("/test7_2")
	public String test7_2(SessionStatus status) {
		//��session�����ע����ָ��������
		//�� @SessionAttributes(value={"user"})��user
		status.setComplete();
		return "index";
	}  
	
	//@Value���βθ�ֵ����ֵ����Ҳ�����᡿����
	@RequestMapping("/test8_1")
	public String test8_1(@Value("Tom") String name) {
		System.out.println(name);
		return "index";
	} 
	
	//SPEL���ʽ
	@RequestMapping("/test8_2")
	public String test8_2(@Value("#{systemProperties['sun.desktop']}") String name) {
		System.out.println(name);
		return "index";
	} 
	
	@RequestMapping("/test8_3")
	public String test8_3(@Value("#{util.name}") String name) {
		System.out.println(name);
		return "index";
	} 
	
	@RequestMapping("/test8_4")
	public String test8_4(@Value("#{util.sayHello().toUpperCase()}") String name) {
		System.out.println(name);
		return "index";
	} 
	
	@RequestMapping("/test8_5")
	public String test8_5(@Value("#{util.sayHello4Null()?.toUpperCase()}") String name) {
		System.out.println(name);
		return "index";
	} 
	
	@RequestMapping("/test8_6")
	public String test8_6(@Value("#{T(java.lang.Math).random()*10}") String name) {
		System.out.println(name);
		return "index";
	} 
	
	
	//@InitBinderע�� ���Խ��������ת����������
	@RequestMapping("/test9")
	public String test9(User user) {
		System.out.println(user);
		return "index";
	}
	
/*	@InitBinder
	public void test(WebDataBinder binder){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		//true��ʾ����Ϊ��
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
	}*/
	
	
	@RequestMapping("/test10")
	public String test10(String param) {
		System.out.println("param:"+param);
		return "index";
	}

}
