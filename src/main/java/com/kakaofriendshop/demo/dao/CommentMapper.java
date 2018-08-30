package com.kakaofriendshop.demo.dao;

import java.util.List;

import com.kakaofriendshop.demo.model.Comment;

public interface CommentMapper {
	/* DB Select  */
    public String getDual() throws Exception;
    public List<Comment> getAllComments() throws Exception;
}
