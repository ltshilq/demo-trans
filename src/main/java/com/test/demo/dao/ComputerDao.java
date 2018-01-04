package com.test.demo.dao;

import org.springframework.stereotype.Repository;

import com.test.demo.bean.Computer;

@Repository
public interface ComputerDao {

	public Computer  getById(int id);
	public void insert(Computer computer);
	public void deleteById(int id);
	public void updateComputerById(Computer computer);
}
