package com.kakaofriendshop.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
    @RequestMapping("/")
    public @ResponseBody String root_test() throws Exception{
        return "Hello World";
    }
}


