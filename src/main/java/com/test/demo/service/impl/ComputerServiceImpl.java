package com.test.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.bean.Computer;
import com.test.demo.dao.ComputerDao;
import com.test.demo.service.ComputerService;

@Service
public class ComputerServiceImpl implements ComputerService{

	
	@Autowired
	ComputerDao computerDao;
	
	
	@Override
	public Computer getById(int id) {
		Computer computer = new Computer();
		computer = computerDao.getById(id);
		return computer;
	}


	@Override
	public void insert(Computer computer) {
		computerDao.insert(computer);		
	}


	@Override
	public void deleteById(int id) {
		computerDao.deleteById(id);
		
	}


	@Override
	public void updateById(Computer computer) {
		computerDao.updateComputerById(computer);
		
	}

}
