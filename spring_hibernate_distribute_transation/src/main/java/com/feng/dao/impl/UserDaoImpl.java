package com.feng.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.feng.dao.UserDao;
import com.feng.model.User;

@Repository("userDao")
public class UserDaoImpl  extends HibernateDaoSupport implements UserDao {

	
	@Override
	public void addUser(User user) {
//		this.getHibernateTemplate().save(user);
//		hibernateTemplate.save(user);
//		this.getHibernateTemplate().save(user);
		Session session = this.getSessionFactory().openSession();  
		session.save(user);;
		session.flush();  
		session.close();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		return this.getHibernateTemplate().execute(new HibernateCallback<List<User>>() {
			@Override
			public List<User> doInHibernate(Session session)
					throws HibernateException {
				return session.createQuery("from User").list();
			}
		});
//		return null;
	}

	@Autowired  
	@Qualifier("sessionFactory01")
	public void setMySessionFactory(SessionFactory sessionFactory){  
	    super.setSessionFactory(sessionFactory);  
	} 


}
