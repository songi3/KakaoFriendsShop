package com.kakaofriendshop.demo.controller;

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

import com.kakaofriendshop.demo.model.Comment;
import com.kakaofriendshop.demo.model.Product;
import com.kakaofriendshop.demo.model.User;
import com.kakaofriendshop.demo.service.CommentService;
import com.kakaofriendshop.demo.service.PayService;
import com.kakaofriendshop.demo.service.ProductService;
import com.kakaofriendshop.demo.service.UserService;

@Controller
public class HomeController {

	@Autowired
	CommentService commentService;
	@Autowired
	UserService userService;
	@Autowired
	ProductService productService;
	@Autowired
	PayService payService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String home(Model model) {
		logger.info("/");

		return "home";
	}

	@RequestMapping("/login")
	public String login() throws Exception {
		logger.info("login");
		return "login";
	}

	@RequestMapping(value = "/sessionCheck", method = RequestMethod.GET)
	@ResponseBody
	public Object board(HttpServletRequest request) {
		logger.info("sessionCheck");

		User sessionLoginInfo = (User) request.getSession().getAttribute("loginUser");
		if (sessionLoginInfo != null) {
			logger.info("sessionLoginInfo is exist");
			return sessionLoginInfo;
		}

		logger.info("sessionLoginInfo is not exist");
		return null;
	}

	// 상품구매 저장
	@RequestMapping(value = "/purchaseProductCommit", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> purchaseProductCommit(String id, String corp_num, String product_code, String count, String settlement_method) {
		
		logger.info("purchaseProductCommit");
		logger.info("purchaseProductCommit :: " + id + "/ " + corp_num);
		
		try {
			payService.setOrderHistory(id, corp_num, product_code, count, settlement_method);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// 회원가입
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup() {
		logger.info("signup");

		return "signup";
	}

	@RequestMapping(value = "/purchaseProduct", method = RequestMethod.GET)
	@ResponseBody
	public Object purchaseProduct(@RequestParam(value = "commentIndex") String commentIndex,
			HttpServletRequest request) {
		logger.info("purchaseProduct");

		logger.info("purchaseProduct : index :: " + commentIndex);

		try {
			Product product = productService.getProduct(commentIndex);
			logger.info("product code :: " + product.getProduct_code());

			Map<String, Object> ProductMap = new HashMap<String, Object>();
			ProductMap.put("product", product);

			return ProductMap;

		} catch (Exception e) {
			logger.info("product code :: error ");
			e.printStackTrace();
		}

		return null;
	}

	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	@ResponseBody
	public Object loginCheck(@RequestParam(value = "id") String id, @RequestParam(value = "password") String password,
			HttpServletRequest request, Model model) {
		logger.info("loginCheck");
		logger.info("id :: " + id + " password :: " + password);

		try {
			User user = userService.checkUserAsPassword(id, password);

			logger.info("user :: " + user);

			if (user == null) {
				logger.info("user is not exist!");
			}

			else {
				logger.info("login success!");
				Map<String, Object> userMap = new HashMap<String, Object>();
				userMap.put("user", user);

				request.getSession().setAttribute("loginUser", user);

				return userMap;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@RequestMapping(value = "/setCommentList", method = RequestMethod.GET)
	@ResponseBody
	public Object setCommentList(HttpServletRequest request) {
		logger.info("setCommentList");

		try {
			List<Comment> commentsList = commentService.getAllComments();

			logger.info("comments :: " + commentsList.size());

			logger.info("comments is exist");
			logger.info("comments count :: " + commentsList.size() + " :: " + commentsList.toString());

			return new ResponseEntity<List<Comment>>(commentsList, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	//회원가입 저장
	@RequestMapping(value = "/signupCommit", method = RequestMethod.POST)
	@ResponseBody
	public Object signupCommit(@Valid User mkUser, BindingResult result) {
		logger.info("signupCommit");
		logger.info("id :: " + mkUser.getId() + " password :: " + mkUser.getPassword());

		List<String> errorMsgs = null;
		//사용자가 모든 입력사항을 입력했는지 검증
		if(result.hasErrors()) {
			errorMsgs = new ArrayList<>();
			List<ObjectError> errors = result.getAllErrors();
			errorMsgs = new ArrayList<>();
			for(ObjectError error : errors) {
				errorMsgs.add(error.getDefaultMessage());
				logger.info("signupCommit :: " + error.getDefaultMessage());
			}
			return errorMsgs;
		}
		
		else {
			try {
				//DB에 새로운 사용자 저장
				userService.createUser(mkUser);
				logger.info("signupCommit :: createUser");
				
				User user = userService.checkUserAsPassword(mkUser.getId(), mkUser.getPassword());
			
				logger.info("signup success!");
			
				return new ResponseEntity<List<String>>(errorMsgs, HttpStatus.OK);
				

			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		logger.info("logout");
		request.getSession().invalidate();

		return "redirect:" + "/";
	}
}
