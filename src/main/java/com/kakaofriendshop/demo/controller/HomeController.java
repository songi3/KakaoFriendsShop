package com.kakaofriendshop.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kakaofriendshop.demo.service.DbService;

@Controller
public class HomeController {
	 @Autowired
	 DbService dbService;

    @RequestMapping("/")
    public String home(){
        return "home";
    }
    
    @RequestMapping("/now")
    public @ResponseBody String demo() throws Exception{
        return dbService.getDual();
    }
}


