package com.student.attendance.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Attendance {
	@Id
	private String id;
	private String name;//学生姓名
	private String leave_data;//备注请假理由
	
	private String start_photo;//开始拍照考勤
	private String start_time;//存储开始考勤时间	
	private String start_status;//开始签到考勤状态（已到、迟到、请假、旷课）

	private String end_photo;//结束拍照考勤
	private Timestamp end_time;//存储结束考勤时间
	private String end_status;//结束签到考勤状态（已到、早退、请假、旷课）
	@ManyToOne // 外键 关联(不要依赖数据库的配置)：寻找另外一张表
	@JoinColumn(name = "userid")
	private User user;// 这个产品是哪一个用户
	
	public String getId() {
		return id;
	}
	public String getLeave_data() {
		return leave_data;
	}
	public void setLeave_data(String leave_data) {
		this.leave_data = leave_data;
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

	public String getStart_photo() {
		return start_photo;
	}
	public void setStart_photo(String start_photo) {
		this.start_photo = start_photo;
	}
	
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getStart_status() {
		return start_status;
	}
	public void setStart_status(String start_status) {
		this.start_status = start_status;
	}
	public String getEnd_photo() {
		return end_photo;
	}
	public void setEnd_photo(String end_photo) {
		this.end_photo = end_photo;
	}
	public Timestamp getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Timestamp end_time) {
		this.end_time = end_time;
	}
	public String getEnd_status() {
		return end_status;
	}
	public void setEnd_status(String end_status) {
		this.end_status = end_status;
	}
	
	
}
