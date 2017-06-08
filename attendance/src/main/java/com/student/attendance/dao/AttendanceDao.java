package com.student.attendance.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.student.attendance.model.Attendance;

@Repository
@Transactional
public class AttendanceDao {
	@PersistenceContext 
	private EntityManager entityManager;
	
	
	public Session getSession() {// 数据库的连接
		return entityManager.unwrap(Session.class);
	}
	public void save(Attendance attendance){
		this.getSession().save(attendance);		
		
	}
}
