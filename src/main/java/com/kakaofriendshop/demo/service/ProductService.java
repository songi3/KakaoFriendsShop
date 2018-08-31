package com.kakaofriendshop.demo.service;

import com.kakaofriendshop.demo.domain.Product;

/**
 * ProductService interface
 * 
 */

public interface ProductService {
	public Product findByIndex(String commentIndex) throws Exception;
}
