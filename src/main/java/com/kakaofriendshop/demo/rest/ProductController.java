package com.kakaofriendshop.demo.rest;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kakaofriendshop.demo.domain.Product;
import com.kakaofriendshop.demo.service.ProductServiceImpl;

@RestController
public class ProductController {

	@Autowired
	ProductServiceImpl productService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Product
	 * 단일 상품 검색
	 * 
	 * @param commentIndex index of comment
	 * @param request HttpServletRequest
	 * @return ResponseEntity<Product>
	 * 
	 * 상품 미확인 404 Not Found
	 * 상품 확인 200 OK
	 * 서버 이상 500 Internal Server Error
	 * */
	@RequestMapping(value = "/product/{commentIndex}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProduct(String commentIndex,
			HttpServletRequest request) {
		
		logger.info("getProduct");
		logger.info("product : index :: " + commentIndex);

		try {
			Product product = productService.findByIndex(commentIndex);
			
			if (product == null) {
				return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
			}
			
			logger.info("product code :: " + product.getProduct_code());
	
			return new ResponseEntity<Product>(product, HttpStatus.OK);

		} catch (Exception e) {
			logger.info("product code :: error ");
			e.printStackTrace();
		}

		return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
