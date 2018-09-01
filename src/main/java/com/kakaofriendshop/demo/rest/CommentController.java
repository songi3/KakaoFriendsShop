package com.kakaofriendshop.demo.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kakaofriendshop.demo.domain.Comment;
import com.kakaofriendshop.demo.domain.User;
import com.kakaofriendshop.demo.service.CommentServiceImpl;

@RestController
public class CommentController {
	
	@Autowired
	CommentServiceImpl commentService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Comment
	 * 다중 게시물 검색
	 * 
	 * @return ResponseEntity<List<Comment>>
	 * 
	 * 게시물 미확인 204 No Content
	 * 게시물 확인 200 OK
	 * 서버 이상 500 Internal Server Error
	 * */
	@RequestMapping(value = "/comment", method = RequestMethod.GET)
	public ResponseEntity<List<Comment>> listAllComments() {
		
		logger.info("listAllComments");

		try {
			List<Comment> commentsList = commentService.findAllComments();

			if (commentsList.isEmpty()) {
				return new ResponseEntity<List<Comment>>(HttpStatus.NO_CONTENT);
			}
			
			logger.info("comments is exist");
			logger.info("comments count :: " + commentsList.size());

			return new ResponseEntity<List<Comment>>(commentsList, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<List<Comment>>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	/**
	 * Comment
	 * 단일 게시물 검색
	 * 
	 * @param user object to be checked
	 * @param request HttpServletRequest
	 * @return ResponseEntity<User>
	 * 
	 * 사용자 정보 미확인 404 Not Found
	 * 사용자 정보 확인 200 OK
	 * 서버 이상 500 Internal Server Error
	 * */
	@RequestMapping(value = "/comment/{index}", method = RequestMethod.GET)
	public ResponseEntity<Comment> getComment(String commentIndex, HttpServletRequest request) {
		
		logger.info("/comment/{index}");
		logger.info("commentIndex :: " + commentIndex);

		try {
			Comment comment = commentService.findCommentByIndex(commentIndex);

			if (comment == null) {
				logger.info("comment is not exist!");
				return new ResponseEntity<Comment>(HttpStatus.NOT_FOUND);
			}

			else {
				logger.info("comment success!");
				
				return new ResponseEntity<Comment>(comment, HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<Comment>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
