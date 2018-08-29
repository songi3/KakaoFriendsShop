package com.kakaofriendshop.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakaofriendshop.demo.dao.UserMapper;
import com.kakaofriendshop.demo.model.User;

@Service
public class UserService {
	@Autowired
	UserMapper userMapper;
	
	public User checkUser(String userId) throws Exception{
		return userMapper.checkUser(userId);
	}
	
	public User checkUserAsPassword(String userId, String userPassword) throws Exception{
		return userMapper.checkUserAsPassword(userId, userPassword);
	};

}
