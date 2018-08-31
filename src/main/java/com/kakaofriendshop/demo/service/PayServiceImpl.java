package com.kakaofriendshop.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakaofriendshop.demo.dao.PayMapper;

/**
 * PayService Implementation
 *
 */

@Service
public class PayServiceImpl implements PayService{
	
	@Autowired
	PayMapper payMapper;
	
	@Override
	public void setOrderHistory(String id, String corp_num, String product_code, String count, String settlement_method) throws Exception{
		payMapper.setOrderHistory(id, corp_num, product_code, count, settlement_method);
	}
}
