package com.kakaofriendshop.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kakaofriendshop.demo.dao.CommentMapper;
import com.kakaofriendshop.demo.domain.Comment;

@Service
public class CommentService implements CommentServiceImpl{
	@Autowired
	CommentMapper commentMapper;
	@Override
    public String getDual() throws Exception{
        return commentMapper.getDual();
    }
	@Override
    public List<Comment> getAllComments() throws Exception{
    	return commentMapper.getAllComments();
    }
	@Override
    public int getProductPrice(String commentIndex) throws Exception{
    	return commentMapper.getProductPrice(commentIndex);
    }
   
	/*public Comment getComment(String commentIndex) throws Exception {
		return commentMapper.getComment(commentIndex);
	}*/
}
