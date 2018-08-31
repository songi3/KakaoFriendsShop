package com.kakaofriendshop.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakaofriendshop.demo.dao.ProductMapper;
import com.kakaofriendshop.demo.domain.Product;

/**
 * ProductService Implementation
 *
 */

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductMapper productMapper;

	@Override
	public Product findByIndex(String commentIndex) throws Exception {
		return productMapper.findByIndex(commentIndex);
	}
}
