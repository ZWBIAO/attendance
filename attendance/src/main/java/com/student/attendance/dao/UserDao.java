package com.student.attendance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.mysql.jdbc.StringUtils;
import com.student.attendance.model.User;

//组件
@Component
// 启动事务
@Transactional
public class UserDao {
	// 注入实体管理器
	@PersistenceContext
	private EntityManager entityManager;

	// 获取数据库连接对象
	public Session getSession() {
		return entityManager.unwrap(Session.class);
	}

	// 通过数据库连接对象保存数据
	public void save(User user) {
		getSession().save(user);
	}

	public void delete(User user) {
		getSession().delete(user);
	}

	public User findById(String id) {
		User user = (User) getSession().get(User.class, id);
		return user;
	}

	public User update(User user) {
		return (User) getSession().merge(user);
	}
	


	public List findAll(String keyword) {
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		if (!StringUtils.isNullOrEmpty(keyword)) {
			Disjunction dis = Restrictions.disjunction();// 或者条件查询对象
			dis.add(Property.forName("title").like(keyword, MatchMode.ANYWHERE));
			dis.add(Property.forName("content").like(keyword, MatchMode.ANYWHERE));
			dc.add(dis);
		}
		dc.addOrder(Order.desc("pubtime"));
		Criteria c = dc.getExecutableCriteria(getSession());
		List list = c.list();
		return list;
	}

//	public User findByAccount(String account) {
//		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
//		dc.add(Property.forName("account").eq(account));
//		Criteria c = dc.getExecutableCriteria(getSession());
//		List list = c.list();
//		if (null != list && list.size() > 0) {
//			return (User)list.get(0);
//		} else {
//			return null;
//		}
//	}
	
	public User findByAccount(String account) {
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Property.forName("account").eq(account));
		Criteria criteria = dc.getExecutableCriteria(getSession());
		List<User> list = criteria.list();
		User user = new User();
		if (null != list && list.size() > 0) {
			return (User)list.get(0);
		} else {
			return null;
		}
	}
	
}
