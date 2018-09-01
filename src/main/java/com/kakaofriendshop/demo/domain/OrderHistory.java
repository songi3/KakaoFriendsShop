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
	
	/**
	 * Index getter, setter
	 */
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	/**
	 * Id getter, setter
	 */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Corp_num getter, setter
	 */
	public String getCorp_num() {
		return corp_num;
	}
	public void setCorp_num(String corp_num) {
		this.corp_num = corp_num;
	}
	
	/**
	 * Product_code getter, setter
	 */
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	
	/**
	 * Count getter, setter
	 */
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
	/**
	 * Reg_date getter, setter
	 */
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	/**
	 * Up_date getter, setter
	 */
	public Date getUp_date() {
		return up_date;
	}
	public void setUp_date(Date up_date) {
		this.up_date = up_date;
	}
	
	/**
	 * Settlement_method getter, setter
	 */
	public String getSettlement_method() {
		return settlement_method;
	}
	public void setSettlement_method(String settlement_method) {
		this.settlement_method = settlement_method;
	}
	
	/**
	 * Price getter, setter
	 */
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
