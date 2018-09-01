package com.kakaofriendshop.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kakaofriendshop.demo.dao.CommentMapper;
import com.kakaofriendshop.demo.domain.Comment;

/**
 * CommentService Implementation
 *
 */

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	CommentMapper commentMapper;
	
	@Override
    public String getDual() throws Exception{
        return commentMapper.getDual();
    }
	
	@Override
    public List<Comment> findAllComments() throws Exception{
    	return commentMapper.findAllComments();
    }
	
	@Override
    public int getProductPrice(String commentIndex) throws Exception{
    	return commentMapper.getProductPrice(commentIndex);
    }
	
	@Override
	public Comment findCommentByIndex(String commentIndex) throws Exception {
		return commentMapper.findCommentByIndex(commentIndex);
	}
}
