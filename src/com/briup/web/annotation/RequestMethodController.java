package com.briup.web.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("requestMethod")
public class RequestMethodController {

	@RequestMapping(value="test1",method=RequestMethod.GET)
	public String test1() {
		return "index";
	}
	
	@RequestMapping(value="test2",method=RequestMethod.POST)
	public String test2() {
		return "index";
	}
	
	
	@RequestMapping(value="test3",method= {RequestMethod.GET,RequestMethod.POST})
	public String test3() {
		return "index";
	}
}
