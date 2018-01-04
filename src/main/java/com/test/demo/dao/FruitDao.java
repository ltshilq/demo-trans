package com.test.demo.dao;

import org.springframework.stereotype.Repository;

import com.test.demo.bean.Fruit;



@Repository
public interface FruitDao {

	public Fruit selectById(int id);
	
	
	public int  priceById(int id);
	
	
	public String  nameById(int id);
}
