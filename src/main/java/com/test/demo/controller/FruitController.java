package com.test.demo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.demo.bean.Fruit;
import com.test.demo.bean.User;
import com.test.demo.service.FruitService;

@Controller
@RequestMapping("/Fruit")
public class FruitController {

	private static Logger Logger = LoggerFactory.getLogger(FruitController.class);


	@Autowired
	FruitService  fs;
	

	
	
	
	@ResponseBody
	@RequestMapping("/getFruit")
	public Fruit getFruit(HttpServletRequest request) {
		String idStr = request.getParameter("id");
		Logger.info("this is test fruit logger"+idStr);
		int id = Integer.parseInt(idStr);
		Fruit f = fs.getFruitById(id);
		
		
		
		return f;
	}

	
	
	@ResponseBody
	@RequestMapping("/getPrice")
	public int getPrice(HttpServletRequest request) {
		int pr = 0;
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		pr = fs.getPriceById(id);
		return pr;
	}

	
	@ResponseBody
	@RequestMapping("/getName")
	public String getName(HttpServletRequest request) {
		String nm = null;
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		nm = fs.getNameById(id);
		return nm;
	}
	
	@ResponseBody
	@RequestMapping("/getName1")
	public String getName1(HttpServletRequest request) {
		String nm = null;
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		nm = fs.getNameById(id);
		return nm;
	}
	
}
