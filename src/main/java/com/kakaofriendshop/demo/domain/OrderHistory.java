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
	Date regDate;
	Date upDate;
	String settlement_method;
	
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
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getUpDate() {
		return upDate;
	}
	public void setUpDate(Date upDate) {
		this.upDate = upDate;
	}
	public String getSettlement_method() {
		return settlement_method;
	}
	public void setSettlement_method(String settlement_method) {
		this.settlement_method = settlement_method;
	}
	
	
}
