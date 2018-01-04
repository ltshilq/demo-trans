package com.test.demo.controller;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.demo.bean.User;
import com.test.demo.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
    

	@Resource
	private IUserService userService;

	static Thread t = new Thread(new Runnable() {
		
		@Override
		public void run() {
			logger.info("启动NR成功"+Thread.currentThread().getId());
			while(true){
				logger.info("这是一个runnable中的初始化方法"+Thread.currentThread().getId());
				logger.debug("debug日志");
				logger.error("error日志");
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}	
			
		}
	});
	
//	@PostConstruct
	public void init() {

		logger.info("执行一个初始化方法");
		if(!t.isAlive())
			t.start();

	}

	@ResponseBody
	@RequestMapping("/get")
	public String get(HttpServletRequest request) {
		logger.info("start to show");
		String ret = null;
		String idStr = request.getParameter("id");
		if (idStr == null) {
			ret = "id cannot be null";
			return ret;
		}
		int id = Integer.parseInt(idStr);
		User user = userService.getUserById(id);
		ret = "result is " + (user == null ? "no user info" : user.toString());
		logger.info(ret);
		return ret;
	}

	@ResponseBody
	@RequestMapping("/insert")
	public String insert(HttpServletRequest request) {
		logger.info("start to insert");

		String ret = null;
		String idStr = request.getParameter("id");
		String name = request.getParameter("name");
		String ageStr = request.getParameter("age");
		String address = request.getParameter("address");
		if (idStr == null || name == null || ageStr == null || address == null) {
			ret = "all parameter cannot be null";
			return ret;
		}

		int id = Integer.parseInt(idStr);
		int age = Integer.parseInt(ageStr);
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setAge(age);
		user.setAddress(address);

		try {
			userService.insertUser(user);
		} catch (Exception e) {
			logger.info("exception:" + e);
			ret = "excption";
			return ret;
		}
		ret = "success";
		logger.info(ret);
		return ret;
	}
}