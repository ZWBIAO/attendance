package com.student.attendance.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.student.attendance.dao.UserDao;
import com.student.attendance.model.User;
import com.student.attendance.valid.UserForm;

@Component
@Transactional
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public void usersave(UserForm userForm){
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setAccount(userForm.getAccount());
		user.setPasswd(userForm.getPasswd());
		user.setName(userForm.getName());
		userDao.save(user);
	}
}
