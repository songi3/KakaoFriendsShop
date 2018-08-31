package com.kakaofriendshop.demo.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHistoryMapper {
	/* DB Select */
	public void saveOrderHistory(@Param("id")String id, @Param("corp_num")String corp_num, @Param("product_code")String product_code, @Param("count")String count, @Param("settlement_method")String settlement_method)
			throws Exception;
}