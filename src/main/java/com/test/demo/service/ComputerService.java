package com.test.demo.service;

import com.test.demo.bean.Computer;

public interface ComputerService {

	public Computer getById(int id);
	public void insert(Computer computer);
	public void deleteById(int id);
	public void updateById(Computer computer);
}
