package com.kakaofriendshop.demo.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kakaofriendshop.demo.domain.Comment;
import com.kakaofriendshop.demo.domain.Product;
import com.kakaofriendshop.demo.domain.User;
import com.kakaofriendshop.demo.service.CommentServiceImpl;
import com.kakaofriendshop.demo.service.OrderHistoryServiceImpl;
import com.kakaofriendshop.demo.service.ProductServiceImpl;
import com.kakaofriendshop.demo.service.UserServiceImpl;

@RestController
public class HomeController {

	@Autowired
	CommentServiceImpl commentService;
	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	ProductServiceImpl productService;
	
	@Autowired
	OrderHistoryServiceImpl orderHistoryService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/sessionLoginInfo", method = RequestMethod.POST)
	public Object getSessionLoginInfo(HttpServletRequest request) {
		
		logger.info("getSessionLoginInfo");

		User sessionLoginInfo = (User) request.getSession().getAttribute("loginUser");
		
		if (sessionLoginInfo != null) {
			
			logger.info("sessionLoginInfo is exist");
			return new ResponseEntity<User>(sessionLoginInfo, HttpStatus.OK);
		}

		logger.info("sessionLoginInfo is not exist");
		return null;
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public ResponseEntity<User> getUser(@RequestParam(value = "id") String id, @RequestParam(value = "password") String password,
			HttpServletRequest request, Model model) {
		
		logger.info("/user/login");
		logger.info("id :: " + id + " password :: " + password);

		try {
			User user = userService.findUserByIdPwd(id, password);

			logger.info("user :: " + user);

			if (user == null) {
				logger.info("user is not exist!");
				return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			}

			else {
				logger.info("login success!");
				request.getSession().setAttribute("loginUser", user);
				return new ResponseEntity<User>(user, HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@RequestMapping(value = "/user/logout", method = RequestMethod.GET)
	public ResponseEntity<Object> logout(HttpServletRequest request) {
		logger.info("logout");
		request.getSession().invalidate();

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<List<String>> createUser(@Valid User mkUser, BindingResult result) {
	
		logger.info("createUser");
		logger.info("id :: " + mkUser.getId() + " password :: " + mkUser.getPassword());

		List<String> errorMsgs = new ArrayList<>();
		
		//사용자의 입력사항을 검증
		if(result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error : errors) {
				errorMsgs.add(error.getDefaultMessage());
				logger.info("createUser :: " + error.getDefaultMessage());
			}
			return new ResponseEntity<List<String>>(errorMsgs, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		else {
			try {				
				//아이디 이미 존재 하는지 검증
				if (userService.isUserExist(mkUser)) {
					errorMsgs.add("아이디가 중복되었습니다.");
					return new ResponseEntity<List<String>>(errorMsgs, HttpStatus.CONFLICT);
				}
					
				//DB에 새로운 사용자 저장
				userService.createUser(mkUser);
				logger.info("signup success!");
			
				return new ResponseEntity<List<String>>(HttpStatus.OK);	

			} catch (Exception e) {
				e.printStackTrace();
			}

			return new ResponseEntity<List<String>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/comment", method = RequestMethod.GET)
	public ResponseEntity<List<Comment>> listAllComments(HttpServletRequest request) {
		
		logger.info("listAllComments");

		try {
			List<Comment> commentsList = commentService.findAllComments();

			if (commentsList.isEmpty()) {
				return new ResponseEntity<List<Comment>>(HttpStatus.NO_CONTENT);
			}
			
			logger.info("comments is exist");
			logger.info("comments count :: " + commentsList.size());

			return new ResponseEntity<List<Comment>>(commentsList, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<List<Comment>>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ResponseEntity<Product> getProduct(@RequestParam(value = "commentIndex") String commentIndex,
			HttpServletRequest request) {
		
		logger.info("getProduct");
		logger.info("product : index :: " + commentIndex);

		try {
			Product product = productService.findByIndex(commentIndex);
			
			if (product == null) {
				return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
			}
			
			logger.info("product code :: " + product.getProduct_code());
	
			return new ResponseEntity<Product>(product, HttpStatus.OK);

		} catch (Exception e) {
			logger.info("product code :: error ");
			e.printStackTrace();
		}

		return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 상품구매 저장
	@RequestMapping(value = "/orderHistory", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Void> createOrderHistory(String id, String corp_num, String product_code, String count, String settlement_method) {
		
		logger.info("createOrderHistory");
		logger.info("info :: " + id + "/ " + corp_num);
		
		try {
			orderHistoryService.saveOrderHistory(id, corp_num, product_code, count, settlement_method);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
}
