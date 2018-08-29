package com.kakaofriendshop.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakaofriendshop.demo.dao.DbMapper;

@Service
public class DbService {
	@Autowired
    DbMapper dbMapper;
 
    public String getDual() throws Exception{
        return dbMapper.getDual();
    }

}
