package com.kakaofriendshop.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakaofriendshop.demo.dao.ProductMapper;
import com.kakaofriendshop.demo.model.Product;

@Service
public class ProductService {
	@Autowired
	ProductMapper productMapper;

	public Product getProduct(String commentIndex) throws Exception {
		return productMapper.getProduct(commentIndex);
	}
}
