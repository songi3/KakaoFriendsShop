package com.kakaofriendshop.demo.service;

import java.util.List;

import com.kakaofriendshop.demo.domain.OrderHistory;

/**
 * OrderHistoryService interface
 * 
 */

public interface OrderHistoryService{
	public void saveOrderHistory(String id, String corp_num, String product_code, String count, String settlement_method)
			throws Exception;
    public List<OrderHistory> findOrderHistoriesById(String userId) throws Exception;
}
