package com.test.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.demo.bean.Computer;
import com.test.demo.service.ComputerService;

@Controller
@RequestMapping("/Computer")
public class ComputerController {

	
	@Autowired
	ComputerService computerService;
	
	
	
	//根据ID找到对应的computer信息
	@ResponseBody
	@RequestMapping("/getbyid")
	public Computer getById(HttpServletRequest request) {
		Computer computer = new Computer();
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		computer = computerService.getById(id);
		return computer;
	}
	
	
	
	//插入一条数据
	@ResponseBody
	@RequestMapping("/insert")
	public String insert(HttpServletRequest request) {
		
		Computer computer = new Computer();
		String idStr = request.getParameter("id");
		String type = request.getParameter("type");
		String priceStr = request.getParameter("price");
		int id = Integer.parseInt(idStr);
		int price = Integer.parseInt(priceStr);
		computer.setId(id);
		computer.setType(type);
		computer.setPrice(price);
		computerService.insert(computer);
		return "success";
	}
	
	
	//根据ID删除某一条数据
	@ResponseBody
	@RequestMapping("/deletebyid")
	public String deleteById(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		computerService.deleteById(id);
		return "success";
	}
	
	
	//根据ID更新一条数据
	@ResponseBody
	@RequestMapping("/updatebyid")
	public String updateById(HttpServletRequest request){
		Computer computer = new Computer();
		int id = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type");
		int price = Integer.parseInt(request.getParameter("price"));
		computer.setId(id);
		computer.setType(type);
		computer.setPrice(price);
		computerService.updateById(computer);
		return "success";
	}
	
	
}
