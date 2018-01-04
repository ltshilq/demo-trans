package com.test.demo.service;

import com.test.demo.bean.Fruit;

public interface FruitService {

	public Fruit getFruitById(int id);
	
	public String getNameById(int id);
	
	public int getPriceById(int id);
	
	
}
