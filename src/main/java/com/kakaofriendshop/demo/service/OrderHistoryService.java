package com.kakaofriendshop.demo.service;

/**
 * OrderHistoryService interface
 * 
 */

public interface OrderHistoryService{
	public void saveOrderHistory(String id, String corp_num, String product_code, String count, String settlement_method)
			throws Exception;
}
