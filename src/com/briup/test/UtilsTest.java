package com.briup.test;

import java.util.Date;

import org.springframework.stereotype.Component;

//@Component("util")
public class UtilsTest {
	
	public String name = "Utils";
	
/*	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}*/

	public String sayHello() {
		return "hello";
	}
	
	public String sayHello(String msg) {
		return "hello"+msg;
	}
	
	public String sayHello4Null() {
		return null;
	}
	
	public int data() {
		return 1024;
	}
	
	public Date now() {
		return new Date();
	}
}
