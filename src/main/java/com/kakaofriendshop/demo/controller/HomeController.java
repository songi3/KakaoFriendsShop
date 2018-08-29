package com.kakaofriendshop.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kakaofriendshop.demo.model.User;
import com.kakaofriendshop.demo.service.DbService;
import com.kakaofriendshop.demo.service.UserService;

@Controller
public class HomeController {
	 @Autowired
	 DbService dbService;
	 @Autowired
	 UserService userService;
	 
	 private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	 
    @RequestMapping("/")
    public String home(){
        return "home";
    }
    
    @RequestMapping("/login")
    public String login() throws Exception{
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
			return "sessionCheck";
		}

		logger.info("sessionLoginInfo is not exist");
		return null;
	}
    
    //회원가입 
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup() {
		logger.info("signup");

		return "signup";
	}
    
    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	@ResponseBody
	public Object loginCheck(@RequestParam(value = "id")String id, @RequestParam(value = "password")String password, HttpServletRequest request, Model model) {
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
    
    @RequestMapping(value = "/signupCommit", method = RequestMethod.POST)
	@ResponseBody
	public Object signupCommit(User mkUser, HttpServletRequest request, Model model) {
		logger.info("signupCommit");
		logger.info("id :: " + mkUser.getId() + " password :: " + mkUser.getPassword());
			
		try {
			userService.createUser(mkUser);
			
			User user = userService.checkUserAsPassword(mkUser.getId(), mkUser.getPassword());
			if (user == null) {
				logger.info("user is not exist!");
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}

			else {
				logger.info("login success!");
				Map<String, Object> userMap = new HashMap<String, Object>();
				userMap.put("user", user);

				request.getSession().setAttribute("loginUser", user);

				return new ResponseEntity<Void>(HttpStatus.OK);
			}		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return null;
	}
    
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		logger.info("logout");
		request.getSession().invalidate();
		
		return "redirect:" + "/";
	}
}


