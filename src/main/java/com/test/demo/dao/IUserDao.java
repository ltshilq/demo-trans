package com.test.demo.dao;

import org.springframework.stereotype.Repository;

import com.test.demo.bean.User;

@Repository
public interface IUserDao {

	public User selectById(int id);

	public int insert(User user);

}
