package com.student.attendance.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.student.attendance.dao.UserDao;
import com.student.attendance.service.UserService;
import com.student.attendance.valid.JsonResult;
import com.student.attendance.valid.UserForm;

@Controller
public class RegisterController {//注册入口
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserService userService;
	@GetMapping("/register")
	public String register(){
		return "register";
	}
	@PostMapping("/register")
	@ResponseBody
	public String registers(Model model,@Valid UserForm userForm,BindingResult result){
		List<JsonResult> arr = new ArrayList<JsonResult>();//有错误的消息,几条？
		if(result.hasErrors()){//判断是否空
			List<ObjectError>list = result.getAllErrors();
			for(ObjectError error : list){
				FieldError fe = (FieldError)error;
				JsonResult jr = new JsonResult();
				jr.setField(fe.getField());
				jr.setMessage(error.getDefaultMessage());
				arr.add(jr);
			}
		}else{
			userService.usersave(userForm);

		}
		return JSON.toJSONString(arr);

	}
}
