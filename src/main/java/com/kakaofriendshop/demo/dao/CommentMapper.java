package com.kakaofriendshop.demo.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.kakaofriendshop.demo.domain.Comment;

public interface CommentMapper {
	/* DB Select  */
    public String getDual() throws Exception;
    public List<Comment> getAllComments() throws Exception;
    public int getProductPrice(String commentIndex) throws Exception;
    public Comment getComment(String commentIndex) throws Exception;
}
