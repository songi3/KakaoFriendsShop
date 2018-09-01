package com.kakaofriendshop.demo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kakaofriendshop.demo.domain.Comment;
import com.kakaofriendshop.demo.domain.OrderHistory;
import com.kakaofriendshop.demo.domain.Product;
import com.kakaofriendshop.demo.domain.User;
import com.kakaofriendshop.demo.service.CommentServiceImpl;
import com.kakaofriendshop.demo.service.OrderHistoryServiceImpl;
import com.kakaofriendshop.demo.service.ProductServiceImpl;
import com.kakaofriendshop.demo.service.UserServiceImpl;

@RestController
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Home
	 * 세션에 저장된 로그인 사용자 정보 검색
	 * 
	 * @param request HttpServletRequest
	 * @return ResponseEntity<User>
	 * 
	 * 세션 사용자 정보 확인 200 OK
	 * 세션 사용자 정보 미확인 404 Not Found
	 * */
	@RequestMapping(value = "/sessionLoginInfo", method = RequestMethod.POST)
	public ResponseEntity<User> getSessionLoginInfo(HttpServletRequest request) {
		
		logger.info("getSessionLoginInfo");

		User sessionLoginInfo = (User) request.getSession().getAttribute("loginUser");
		
		if (sessionLoginInfo != null) {
			
			logger.info("sessionLoginInfo is exist");
			return new ResponseEntity<User>(sessionLoginInfo, HttpStatus.OK);
		}

		logger.info("sessionLoginInfo is not exist");
		return new ResponseEntity<User>(sessionLoginInfo, HttpStatus.NOT_FOUND);
	}

	/**
	 * Home
	 * 세션 저장된 정보 삭제
	 * 
	 * @param request HttpServletRequest
	 * @return ResponseEntity<Void>
	 * 
	 * 세션 사용자 정보 삭제 200 OK
	 * */
	@RequestMapping(value = "/user/logout", method = RequestMethod.DELETE)
	public ResponseEntity<Void> logout(HttpServletRequest request) {
		logger.info("logout");
		request.getSession().invalidate();

		return new ResponseEntity<Void>(HttpStatus.OK);
	}	
}
