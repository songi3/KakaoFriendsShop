package com.kakaofriendshop.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakaofriendshop.demo.dao.UserMapper;
import com.kakaofriendshop.demo.domain.User;

/**
 * UserService Implementation
 *
 */

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public User checkUser(String userId) throws Exception{
		return userMapper.findUserById(userId);
	}
	
	@Override
	public User findUserByIdPwd(String userId, String userPassword) throws Exception{
		return userMapper.findUserByIdPwd(userId, userPassword);
	}
	
	@Override
	public void createUser(User mkUser) throws Exception{
		userMapper.createUser(mkUser);
	}
	
	@Override
	public Boolean isUserExist(User user) throws Exception{
		
		if (user.getId() != null) {
			final User existingUser = userMapper.findUserById(user.getId());
			if (existingUser == null) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}	
	}
}
