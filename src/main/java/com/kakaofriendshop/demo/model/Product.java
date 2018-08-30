package com.kakaofriendshop.demo.model;

import java.util.Date;

public class Product {

	String corp_num;
	String product_code;
	String product_name;
	String n_origin;
	String c_origin;
	int price;
	
	public String getCorp_num() {
		return corp_num;
	}
	public void setCorp_num(String corp_num) {
		this.corp_num = corp_num;
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getN_origin() {
		return n_origin;
	}
	public void setN_origin(String n_origin) {
		this.n_origin = n_origin;
	}
	public String getC_origin() {
		return c_origin;
	}
	public void setC_origin(String c_origin) {
		this.c_origin = c_origin;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
