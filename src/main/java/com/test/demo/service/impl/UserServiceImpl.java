package com.test.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.demo.bean.User;
import com.test.demo.dao.IUserDao;
import com.test.demo.service.IUserService;

@Transactional
@Service
public class UserServiceImpl implements IUserService {

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private IUserDao userDao;

	public UserServiceImpl() {

	}

	public User getUserById(int id) {
		return userDao.selectById(id);
	}

	public void insertUser(User user) {

		int rows = userDao.insert(user);
		logger.info("rows:" + rows);
		if (rows != 1) {
			throw new RuntimeException();
		}

		user.setId(user.getId() + 1);
		userDao.insert(user);

	}

}
