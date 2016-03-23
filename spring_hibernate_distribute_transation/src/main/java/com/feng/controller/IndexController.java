package com.feng.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.feng.dao.UserDao;
import com.feng.model.User;
import com.feng.model2.Man;
import com.feng.model2.dao.ManDao;

@Controller
public class IndexController {

	@Resource(name="userDao")
	private UserDao userDao;
	
	@Resource(name="manDao")
	private ManDao manDao;
	
	@RequestMapping("/")
	public String index() {
		System.out.println("goto index.jsp");
		return "index";
	}
	
	@RequestMapping("/index")
	public String hello() {
		List<User> list = userDao.getAll();
		for(User u : list) {
			System.out.println(u.getName());
		}
		System.out.println("hello");
		return "index";
	}
	
	@RequestMapping("/addUser") 
	public String addUser(@RequestParam("name") String name) {
		User user = new User();
		System.out.println(name);
		user.setName(name);
		userDao.addUser(user);
		
		Man man = new Man();
		man.setName("wade");
		man.setPassword("wade");
		manDao.addMan(man);
		return "success";
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
