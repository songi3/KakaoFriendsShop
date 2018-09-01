package com.kakaofriendshop.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kakaofriendshop.demo.domain.OrderHistory;

@Repository
public interface OrderHistoryMapper {
	
	/* DB Select */
	public void saveOrderHistory(OrderHistory orderHistory)
			throws Exception;
    public List<OrderHistory> findOrderHistoriesById(@Param("userId")String userId) throws Exception;
}
