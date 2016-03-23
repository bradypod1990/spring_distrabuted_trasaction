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
public class AdviceTest {

	@Resource(name="adviceService")
	private AdviceService adviceService;
	
	
	@Test
	public void getAll() {
		adviceService.hello();
	}
}
