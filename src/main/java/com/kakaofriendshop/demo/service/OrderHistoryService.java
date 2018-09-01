package com.kakaofriendshop.demo.service;

import java.util.List;

import com.kakaofriendshop.demo.domain.OrderHistory;

/**
 * OrderHistoryService interface
 * 
 */

public interface OrderHistoryService{
	public void saveOrderHistory(OrderHistory orderHistory)
			throws Exception;
    public List<OrderHistory> findOrderHistoriesById(String userId) throws Exception;
}
