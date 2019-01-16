package com.briup.bean;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Teacher {

	//@Null //只能是null
	//@NotNull	//值不能为null
	//@NotEmpty   //值不为null且不为空  null  ""
	//@NotBlank
	//@Pattern(regexp = "^\\d{4}-\\w{4}$")
	@Size(min=2,max=4)
	private String name;
	//@Min(value = 1)
	@Max(value=18)
	private int age;
	@Future		
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dob;
	
	public Teacher() {
		super();
	}
	
	public Teacher(String name, int age, Date dob) {
		super();
		this.name = name;
		this.age = age;
		this.dob = dob;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", age=" + age + ", dob=" + dob + "]";
	}
	
}
