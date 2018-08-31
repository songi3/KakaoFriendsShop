package com.kakaofriendshop.demo.service;

import com.kakaofriendshop.demo.domain.User;

/**
 * UserService interface
 * 
 */

public interface UserService {
	public User checkUser(String userId) throws Exception;
	public User findUserByIdPwd(String userId, String userPassword) throws Exception;
	public void createUser(User mkUser) throws Exception;
	public Boolean isUserExist(User user) throws Exception;
}
