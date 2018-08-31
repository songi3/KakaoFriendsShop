package com.kakaofriendshop.demo.domain;

import java.util.Date;

import javax.persistence.Entity;


/**
 * Comment Entity
 *
 */

@Entity
public class Comment {

	int index;
	String corp_num;
	String product_code;
	String title;
	String sub_title;
	Date reg_date;
	Date up_date;
	String comment;
	int like;
	String thumbnail;
	String use_YN;
	int price;
	
	/**
	 * Index getter, setter
	 */
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	/**
	 * Corp_num getter, setter
	 */
	public String getCorp_num() {
		return corp_num;
	}
	public void setCorp_num(String corp_num) {
		this.corp_num = corp_num;
	}
	
	/**
	 * Price getter, setter
	 */
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * Product_code getter, setter
	 */
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	
	/**
	 * Title getter, setter
	 */
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Sub_title getter, setter
	 */
	public String getSub_title() {
		return sub_title;
	}
	public void setSub_title(String sub_title) {
		this.sub_title = sub_title;
	}
	
	/**
	 * Reg_date getter, setter
	 */
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	/**
	 * Up_date getter, setter
	 */
	public Date getUp_date() {
		return up_date;
	}
	public void setUp_date(Date up_date) {
		this.up_date = up_date;
	}
	
	/**
	 * Comment getter, setter
	 */
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	/**
	 * Like getter, setter
	 */
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	
	/**
	 * Thumbnail getter, setter
	 */
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	/**
	 * Use_YN getter, setter
	 */
	public String getUse_YN() {
		return use_YN;
	}
	public void setUse_YN(String use_YN) {
		this.use_YN = use_YN;
	}

}
