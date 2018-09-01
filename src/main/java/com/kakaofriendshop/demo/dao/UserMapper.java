package com.kakaofriendshop.demo.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kakaofriendshop.demo.domain.User;

/**
 * Repository for User entity
 *
 */

@Repository
public interface UserMapper {

    public User findUserById(String userId) throws Exception;
    public User findUserByIdPwd(@Param("userId")String userId, @Param("userPassword")String userPassword) throws Exception;
    public void createUser(User mkUser) throws Exception;
}
