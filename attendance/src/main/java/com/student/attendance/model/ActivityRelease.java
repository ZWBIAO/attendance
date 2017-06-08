package com.student.attendance.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ActivityRelease {
	@Id
	private String id;
	private String activityName;//活动名称
	private Timestamp create_date;//活动创建时间
	private Timestamp end_date;//活动结束时间
	@OneToMany(fetch=FetchType.LAZY ,mappedBy = "user")//绑定user
	private Set<Attendance> attendance = new HashSet<Attendance>();
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	public Timestamp getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Timestamp end_date) {
		this.end_date = end_date;
	}

	
}
