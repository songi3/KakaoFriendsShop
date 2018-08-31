package com.kakaofriendshop.demo.service;

import com.kakaofriendshop.demo.domain.User;

/**
 * UserService interface
 * 
 */

public interface UserService {
	public User checkUser(String userId) throws Exception;
	public User checkUserAsPassword(String userId, String userPassword) throws Exception;
	public void createUser(User mkUser) throws Exception;
}
