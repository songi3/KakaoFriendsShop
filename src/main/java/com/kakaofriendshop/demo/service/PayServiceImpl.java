package com.kakaofriendshop.demo.service;

public interface PayServiceImpl{
	public void setOrderHistory(String id, String corp_num, String product_code, String count, String settlement_method)
			throws Exception;
}
