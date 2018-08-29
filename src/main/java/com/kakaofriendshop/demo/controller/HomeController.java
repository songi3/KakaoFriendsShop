package com.kakaofriendshop.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
}


