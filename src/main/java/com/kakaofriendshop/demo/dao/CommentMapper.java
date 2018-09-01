package com.kakaofriendshop.demo.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.kakaofriendshop.demo.domain.Comment;

/**
 * Repository for Comment entity
 *
 */

@Repository
public interface CommentMapper {
	/* DB Select  */
    public String getDual() throws Exception;
    public List<Comment> findAllComments() throws Exception;
    public int getProductPrice(String commentIndex) throws Exception;
    public Comment findCommentByIndex(String commentIndex) throws Exception;
}
