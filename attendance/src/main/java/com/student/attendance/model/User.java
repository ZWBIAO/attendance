package com.student.attendance.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class User {
	@Id
	private String id;
	private String name;//姓名
	private String account;//学号
	private String passwd;//密码
	private String phone;//手机号码
	@OneToMany(fetch=FetchType.LAZY ,mappedBy = "user")//绑定user
	private Set<Attendance> attendance = new HashSet<Attendance>();
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Set<Attendance> getAttendance() {
		return attendance;
	}
	public void setAttendance(Set<Attendance> attendance) {
		this.attendance = attendance;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
