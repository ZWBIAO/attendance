package com.student.attendance.valid;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class LoginForm {
//	@Size(min=9, max=9, message="请填正确的学号")
//	@NotBlank(message="账号不能为空")
	private String account;
//	@NotBlank(message="密码不能为空")
	private String passwd;


	public LoginForm() {
	}
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
}
