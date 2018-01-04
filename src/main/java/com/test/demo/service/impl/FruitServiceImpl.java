package com.test.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.demo.bean.Fruit;
import com.test.demo.dao.FruitDao;
import com.test.demo.service.FruitService;

@Transactional
@Service
public class FruitServiceImpl implements FruitService{

	@Autowired
	public FruitDao fDao;
	
    public Fruit getFruitById(int id){
    	
    	Fruit fr = fDao.selectById(id);
		return fr;
    	
    }
	
	public String getNameById(int id){
		
		String nm = fDao.nameById(id);
		return nm;
		
	}
	
	public int getPriceById(int id){
		
		int pr = fDao.priceById(id);
		return pr;
	}
}
