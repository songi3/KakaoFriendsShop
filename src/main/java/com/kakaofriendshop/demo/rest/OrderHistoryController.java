package com.kakaofriendshop.demo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kakaofriendshop.demo.domain.OrderHistory;
import com.kakaofriendshop.demo.service.OrderHistoryServiceImpl;

@RestController
public class OrderHistoryController {
	
	@Autowired
	OrderHistoryServiceImpl orderHistoryService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * OrderHistory
	 * 구매 이력 생성
	 * 
	 * @param orderHistory object to be created
	 * @return ResponseEntity<Void>
	 * 
	 * 단일 구매 이력 생성 201 Created
	 * 서버 이상 500 Internal Server Error
	 * */
	@RequestMapping(value = "/orderHistory", method = RequestMethod.POST)
	public ResponseEntity<Void> createOrderHistory(@RequestBody OrderHistory orderHistory) {
		
		logger.info("createOrderHistory");
		logger.info("info :: " + orderHistory.getId() + "/ " + orderHistory.getCorp_num());
		
		try {
			orderHistoryService.saveOrderHistory(orderHistory.getId(), orderHistory.getCorp_num(), orderHistory.getProduct_code(), orderHistory.getCount(), orderHistory.getSettlement_method());
			return new ResponseEntity<Void>(HttpStatus.CREATED);
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
