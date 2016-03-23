package com.feng.model2.dao;

import java.util.List;

import com.feng.model2.Man;

public interface ManDao {

	
	public void addMan(Man man);
	
	public List<Man> findAll();
}
