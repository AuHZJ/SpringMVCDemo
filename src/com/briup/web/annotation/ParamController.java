package com.briup.web.annotation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.briup.bean.User;

@Controller
@RequestMapping("/param")
public class ParamController {
	//HttpServletRequest
	//HttpServletResponse
	@RequestMapping("/test1")
	public void  test1(HttpServletRequest request,HttpServletResponse response) {
		System.out.println(request);
		//HttpSession session = request.getSession();
		request.setAttribute("msg", "hello test1");
		System.out.println(response);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	//InputStream/OutputStream
	@RequestMapping("/test2_1")
	public void test2_1(InputStream is, OutputStream os) {
		System.out.println(is);
		System.out.println(os);
	}
	
	//Reader/Writer
	@RequestMapping("/test2_2")
	public void test2_2(Reader r, Writer w) {
		System.out.println(r);
		System.out.println(w);
		try {
			BufferedWriter bw = new BufferedWriter(w);
			
			bw.write("hello");
			bw.flush(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//WebRequest/NativeWebRequest
	@SuppressWarnings("unused")
	@RequestMapping("/test3")
	public String test3(WebRequest webRequest, NativeWebRequest nativeWebRequest) {
		//功能更全面的一个request
		System.out.println(webRequest.getParameter("test"));
		
		webRequest.setAttribute("name", "value",WebRequest.SCOPE_REQUEST);  
		System.out.println(webRequest.getAttribute("name", WebRequest.SCOPE_REQUEST));  
		
		HttpServletRequest request =   
			nativeWebRequest.getNativeRequest(HttpServletRequest.class);
		HttpServletResponse response =   
			nativeWebRequest.getNativeResponse(HttpServletResponse.class); 
	
		return "index";
	}
	
	//HttpSession
	@RequestMapping("test4")
	public String test4(HttpSession session) {
		int time = session.getMaxInactiveInterval();
		System.out.println(time);//单位：秒
		//1800s=30m
		return "index";
	}
	
	//命令/表单对象	//id=101&name=zs&age=22&dob=2018-11-19
	@RequestMapping("test5")
	public String test5(User user) {
		System.out.println(user);
		return "index";
	}
	
	//Model Map  ModelMap
	@RequestMapping("test6")
	public String test6(Model m,Map<String, String> map,ModelMap mm) {
		m.addAttribute("m", "Model");
		map.put("map", "Map");
		mm.put("mm", "ModelMap");
		
		System.out.println(m == map);
		System.out.println(m == mm);
		
		return "index";
	}
	
	
	@RequestMapping("test7")
	public String test7(HttpEntity<String> httpEntity) {
		//获取请求头
		HttpHeaders headers = httpEntity.getHeaders();
		System.out.println(headers);
		
		//获取请求体
		//Get
		//Post
		String body = httpEntity.getBody();
		System.out.println(body);
		
		return "index";
	}
	
	//用来清除使用@SessionAttributes注解放到session中的数据
	@RequestMapping("/test8")
	public String test8(SessionStatus status) {
		System.out.println(status);
		
		return "index";
	}
	
	@RequestMapping("/test9")
	public String test9(User user,RedirectAttributes redirectAttributes,HttpServletRequest request ,HttpServletResponse response) {
		System.out.println(user);
		//request.setAttribute("user", user);
		redirectAttributes.addFlashAttribute("user", user);
		redirectAttributes.addFlashAttribute("msg", "注册成功");
//		redirectAttributes.addAttribute("m", "model");
		
		try {
			//request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
			//response.sendRedirect("../index");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:../index";
	}
	
	//绑定错误信息等，特殊数据格式
	@RequestMapping("/test10")
	public String test10(BindingResult br) {
		System.out.println(br);
		return "index";
	}
}
