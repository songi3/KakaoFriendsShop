package com.kakaofriendshop.demo.service;

/**
 * PayService interface
 * 
 */

public interface PayService{
	public void setOrderHistory(String id, String corp_num, String product_code, String count, String settlement_method)
			throws Exception;
}
