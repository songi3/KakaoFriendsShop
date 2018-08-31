package com.kakaofriendshop.demo.service;

import java.util.List;

import com.kakaofriendshop.demo.domain.Comment;

/**
 * CommentService interface
 * 
 */

public interface CommentService {
		public String getDual() throws Exception;
	    public List<Comment> findAllComments() throws Exception;
	    public int getProductPrice(String commentIndex) throws Exception;
}
