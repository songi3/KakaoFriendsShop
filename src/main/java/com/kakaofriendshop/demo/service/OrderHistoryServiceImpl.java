package com.kakaofriendshop.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kakaofriendshop.demo.dao.OrderHistoryMapper;

/**
 * OrderHistoryService Implementation
 *
 */

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService{
	
	@Autowired
	OrderHistoryMapper orderHistoryMapper;
	
	@Override
	public void saveOrderHistory(String id, String corp_num, String product_code, String count, String settlement_method) throws Exception{
		orderHistoryMapper.saveOrderHistory(id, corp_num, product_code, count, settlement_method);
	}
}
