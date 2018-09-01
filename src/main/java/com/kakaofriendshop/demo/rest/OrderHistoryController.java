package com.kakaofriendshop.demo.rest;

import java.util.List;

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
			orderHistoryService.saveOrderHistory(orderHistory);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * OrderHistory
	 * 다중 구매 이력 검색
	 * 
	 * @param user id to be selected
	 * @return ResponseEntity<List<OrderHistory>>
	 * 
	 * 구매이력 미확인 204 No Content
	 * 구매이력 확인 200 OK
	 * 서버 이상 500 Internal Server Error
	 * */
	@RequestMapping(value = "/orderHistory/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<OrderHistory>> listOrderHistoriesById(String id) {
		
		logger.info("listOrderHistoriesById");
	
		try {
			List<OrderHistory> orderHistoriesList = orderHistoryService.findOrderHistoriesById(id);

			if (orderHistoriesList.isEmpty()) {
				return new ResponseEntity<List<OrderHistory>>(HttpStatus.NO_CONTENT);
			}
			
			logger.info("orderHistories are exist");
			logger.info("orderHistory count :: " + orderHistoriesList.size());

			return new ResponseEntity<List<OrderHistory>>(orderHistoriesList, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<List<OrderHistory>>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
