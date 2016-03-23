package com.feng.model2;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.feng.model2.dao.ManDao;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations={"classpath:spring-common.xml"})
@TransactionConfiguration(transactionManager="transactionManager2",defaultRollback=false)
public class ManTest {

	
	@Resource(name="manDao")
	private ManDao manDao;
	
	@Test
	public void addMan() {
		Man man = new Man();
		man.setName("james");
		man.setPassword("james");
		manDao.addMan(man);
	}
	
	@Test
	public void findMan() {
		List<Man> list = manDao.findAll();
		if(list != null) {
			for(Man man: list) {
				System.out.println(man.getId() + "--" + man.getPassword() + "=----" + man.getName());
			}
		}
	}
}
