package com.kakaofriendshop.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakaofriendshop.demo.dao.UserMapper;
import com.kakaofriendshop.demo.domain.User;

@Service
public class UserService implements UserServiceImpl{
	@Autowired
	UserMapper userMapper;
	@Override
	public User checkUser(String userId) throws Exception{
		return userMapper.checkUser(userId);
	}
	@Override
	public User checkUserAsPassword(String userId, String userPassword) throws Exception{
		return userMapper.checkUserAsPassword(userId, userPassword);
	};
	@Override
	public void createUser(User mkUser) throws Exception{
		userMapper.createUser(mkUser);
	}
}
