package com.test.demo.service;

import com.test.demo.bean.User;

public interface IUserService {
	
	 public User getUserById(int id);
	
	 public void insertUser(User user);
	 
}
