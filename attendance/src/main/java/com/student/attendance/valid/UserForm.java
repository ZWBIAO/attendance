package com.student.attendance.valid;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class UserForm {
	@Size(min=9, max=9, message="请填正确的学号")
	public  String account;
	
	@NotBlank(message="姓名不能为空")
	private String name;
	@Size(min=6, max=6, message="输入六位密码")
	public String passwd;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	
}