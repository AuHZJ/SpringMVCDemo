package com.briup.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.briup.web.converter.DateJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class User {
	
	private Long id;
	private String name;
	private int age;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dob;
	
	public User() {
		super();
	}
	
	public User(Long id, String name) {
		this(id,name,0,new Date());
	}
	
	public User(Long id, String name, int age) {
		this(id,name,age,new Date());
	}
	
	public User(Long id, String name, int age, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.dob = dob;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@JsonSerialize(using=DateJsonSerializer.class)
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", dob=" + (dob.getYear()+1900)+"-"+(dob.getMonth()+1)+"-"+dob.getDate()+ "]";
	}
	
//	arr= {1,2,3,4,5,6,7,8,9,10,11,12}
	
}
