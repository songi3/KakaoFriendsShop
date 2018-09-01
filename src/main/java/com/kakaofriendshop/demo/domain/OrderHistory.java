package com.kakaofriendshop.demo.domain;

import java.util.Date;

/**
 * OrderHistory Entity
 *
 */

public class OrderHistory {
	
	int index;
	String id;
	String corp_num;
	String product_code;
	String count;
	Date reg_date;
	Date up_date;
	String settlement_method;
	int price;
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public Date getUp_date() {
		return up_date;
	}
	public void setUp_date(Date up_date) {
		this.up_date = up_date;
	}
	public String getSettlement_method() {
		return settlement_method;
	}
	public void setSettlement_method(String settlement_method) {
		this.settlement_method = settlement_method;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
