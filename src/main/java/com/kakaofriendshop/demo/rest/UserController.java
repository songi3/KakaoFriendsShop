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
import org.springframework.web.bind.annotation.RestController;

import com.kakaofriendshop.demo.domain.User;
import com.kakaofriendshop.demo.service.UserServiceImpl;

@RestController
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	/**
	 * User
	 * 단일 사용자 검색
	 * 
	 * @param user object to be checked
	 * @param request HttpServletRequest
	 * @return ResponseEntity<User>
	 * 
	 * 사용자 정보 미확인 404 Not Found
	 * 사용자 정보 확인 200 OK
	 * 서버 이상 500 Internal Server Error
	 * */
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public ResponseEntity<User> getUser(@RequestBody User tempUser, HttpServletRequest request) {
		
		logger.info("/user/login");
		logger.info("id :: " + tempUser.getId() + " password :: " + tempUser.getPassword());

		try {
			User user = userService.findUserByIdPwd(tempUser.getId(), tempUser.getPassword());

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

		return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * User
	 * 단일 사용자 생성
	 * 
	 * @param user object to be created
	 * @param result BindingResult
	 * @return ResponseEntity<List<String>>
	 * 
	 * 아이디 중복 409 Conflict
	 * 사용자 입력사항 검증 에러 400 Bad Request
	 * 단일 사용자 생성 완료 200 OK
	 * 서버 이상 500 Internal Server Error
	 * */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<List<String>> createUser(@Valid @RequestBody User mkUser, BindingResult result) {
	
		logger.info("createUser");
		logger.info("id :: " + mkUser.getId() + " password :: " + mkUser.getPassword());

		List<String> errorMsgs = new ArrayList<>();
		
		try {		
		
		//아이디 존재 여부 확인
		if (userService.isUserExist(mkUser)) {
			errorMsgs.add("아이디가 중복되었습니다.");
			return new ResponseEntity<List<String>>(errorMsgs, HttpStatus.CONFLICT);
		}
		
		//사용자의 입력사항 검증
		if(result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error : errors) {
				errorMsgs.add(error.getDefaultMessage());
				logger.info("createUser :: " + error.getDefaultMessage());
			}
			return new ResponseEntity<List<String>>(errorMsgs, HttpStatus.BAD_REQUEST);
		}
		
		else {		
				//단일 사용자 생성
				userService.createUser(mkUser);
				logger.info("signup success!");
			
				return new ResponseEntity<List<String>>(HttpStatus.OK);		
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<List<String>>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
