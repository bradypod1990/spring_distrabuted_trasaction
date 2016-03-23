package com.feng.model2.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.feng.model.User;
import com.feng.model2.Man;
import com.feng.model2.dao.ManDao;


@Repository("manDao")
public class ManDaoImpl  extends HibernateDaoSupport implements ManDao {

	@Override
	public void addMan(Man man) {

		//this.getHibernateTemplate().save(man);
		Session session = this.getSessionFactory().openSession();
		session.save(man);
		session.flush();
		session.close();
				
	}

	@Override
	public List<Man> findAll() {
		return this.getHibernateTemplate().execute(new HibernateCallback<List<Man>>() {
			@Override
			public List<Man> doInHibernate(Session session)
					throws HibernateException {
				return session.createQuery("from Man").list();
			}
		});
	}

	
	@Autowired  
	@Qualifier("sessionFactory02")
	public void setMySessionFactory(SessionFactory sessionFactory){  
	    super.setSessionFactory(sessionFactory);  
	} 

}
