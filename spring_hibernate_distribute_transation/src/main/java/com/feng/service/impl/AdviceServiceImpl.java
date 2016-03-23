package com.feng.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.feng.dao.UserDao;
import com.feng.model.User;
import com.feng.model2.Man;
import com.feng.model2.dao.ManDao;
import com.feng.service.AdviceService;

@Service("adviceService")
public class AdviceServiceImpl implements AdviceService {

	@Resource(name="userDao")
	private UserDao userDao;
	
	@Resource(name="manDao")
	private ManDao manDao;
	
	@Override
	public void hello() {
		System.out.println("----------------------------hello");

	}

	@Override
	public void add() {
		User user = new User();
		user.setName("test444");
		userDao.addUser(user);
		Man man = new Man();
		man.setName("hello4");
		man.setPassword("hello4");
		
		manDao.addMan(man);
	}

}
