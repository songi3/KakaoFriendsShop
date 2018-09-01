package com.kakaofriendshop.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakaofriendshop.demo.dao.OrderHistoryMapper;
import com.kakaofriendshop.demo.domain.OrderHistory;

/**
 * OrderHistoryService Implementation
 *
 */

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService{
	
	@Autowired
	OrderHistoryMapper orderHistoryMapper;
	
	@Override
	public void saveOrderHistory(OrderHistory orderHistory) throws Exception{
		orderHistoryMapper.saveOrderHistory(orderHistory);
	}
	
	@Override
    public List<OrderHistory> findOrderHistoriesById(String userId) throws Exception{
    	return orderHistoryMapper.findOrderHistoriesById(userId);
    }
}
