package com.briup.web.annotation;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("error")
public class ErrorController {
	@RequestMapping("test")
	public String test() throws IOException {
		
		//int i=1/0;
		throw new IOException("IO“Ï≥££°£°£°");
		//return "index";
	}

	
	@ExceptionHandler(value={IOException.class,SQLException.class})  
	public String exp(Exception ex,HttpServletRequest request) {  
		request.setAttribute("ex", ex);  
		return "error_io";  
	}  
}
