package com.kakaofriendshop.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakaofriendshop.demo.dao.ProductMapper;
import com.kakaofriendshop.demo.domain.Product;

@Service
public class ProductService implements ProductServiceImpl{
	@Autowired
	ProductMapper productMapper;
	@Override
	public Product getProduct(String commentIndex) throws Exception {
		return productMapper.getProduct(commentIndex);
	}
}
