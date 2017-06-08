package com.student.attendance.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.student.attendance.dao.UserDao;
import com.student.attendance.model.User;
import com.student.attendance.service.UserService;
import com.student.attendance.valid.JsonResult;
import com.student.attendance.valid.LoginForm;

@Controller
public class LoginController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String login() {
		return "login";

	}
	@PostMapping("/login")
	@ResponseBody
	public String logins(HttpSession httpSession, @Valid LoginForm loginForm, BindingResult result) {
		User user = userDao.findByAccount(loginForm.getAccount());// 查找表单与数据库是否相同
		if (null != user) {
			if (StringUtils.equals(user.getPasswd(), loginForm.getPasswd())) {
				httpSession.setAttribute("loginuser", user);
				System.out.println("1111111");
				return "成功";
			} else {
				return "账号或者密码错误";
			}
		} else {
			return "账号密码不能为空";
		}
	}
}