package com.test.demo.bean;

public class Computer {

	int id;
	String type;
	int price;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	@Override
	public String toString() {
		return "Computer [id=" + id + ", type=" + type + ", price=" + price + "]";
	}
	
	
	
}
