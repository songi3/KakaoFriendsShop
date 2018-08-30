package com.kakaofriendshop.demo.service;

import java.util.List;

import com.kakaofriendshop.demo.domain.Comment;

public interface CommentServiceImpl {
		public String getDual() throws Exception;
	    public List<Comment> getAllComments() throws Exception;
	    public int getProductPrice(String commentIndex) throws Exception;
}
