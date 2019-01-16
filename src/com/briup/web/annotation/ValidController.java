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
		//�����֤�������д�����Ϣ,��������bindingResult������
		if(bindingResult.hasErrors()){
			List<ObjectError> errorList = bindingResult.getAllErrors();             
			for(ObjectError error : errorList){                 
				System.out.println(error.getDefaultMessage());             
			}
			//��֤��ͨ��������validҳ��,��Ϊҳ��������ʾ����ı�ǩ
			return "valid";
		}
		
		//û�д���������helloҳ��
		return "index";
	}
	
}
