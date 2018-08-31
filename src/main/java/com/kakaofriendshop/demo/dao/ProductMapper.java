package com.kakaofriendshop.demo.dao;

import org.springframework.stereotype.Repository;

import com.kakaofriendshop.demo.domain.Product;

/**
 * Repository for Product entity
 *
 */

@Repository
public interface ProductMapper {
	/* DB Select  */
    public int getProductPrice(String commentIndex) throws Exception;
    public Product findByIndex(String commentIndex) throws Exception;
}
