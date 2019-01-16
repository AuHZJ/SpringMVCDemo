package com.briup.web.annotation;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.briup.bean.Teacher;

@Controller
@RequestMapping("/valid")
public class ValidController {

	@RequestMapping(value="/user/add", method = {RequestMethod.GET})
	public String showAddPage(Model model){
		if(!model.containsAttribute("teacher")){
			model.addAttribute("teacher", new Teacher());
		}
		return "valid";
	}
	
	@RequestMapping(value="/user/add",method = {RequestMethod.POST})
	public String addTeacher(@Valid Teacher teacher,BindingResult bindingResult){
		//如果验证数据中有错误信息,将保存在bindingResult对象中
		if(bindingResult.hasErrors()){
			List<ObjectError> errorList = bindingResult.getAllErrors();             
			for(ObjectError error : errorList){                 
				System.out.println(error.getDefaultMessage());             
			}
			//验证不通过在跳到valid页面,因为页面上有显示错误的标签
			return "valid";
		}
		
		//没有错误则跳到hello页面
		return "index";
	}
	
}
