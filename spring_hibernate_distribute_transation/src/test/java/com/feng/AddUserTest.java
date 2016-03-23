package com.feng;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.feng.dao.UserDao;
import com.feng.model.User;
import com.feng.service.AdviceService;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations={"classpath:spring-common.xml"})
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)
public class AddUserTest {

	@Resource(name="userDao")
	private UserDao userDao;
	
	@Resource(name="adviceService")
	private AdviceService adviceService;
	

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Test
	public void addUser() {
		User user = new User();
//		user.setId(3);
		user.setName("wade2");
		userDao.addUser(user);
	}
	
	@Test
	public void add() {
		adviceService.add();
	}
	
	
	@Test
	public void getAll() {
		List<User> list = userDao.getAll();
		for(User u : list) {
			System.out.println(u.getName() + "----" + u.getId());
		}
	}
}
