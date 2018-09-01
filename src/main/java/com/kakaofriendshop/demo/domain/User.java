package com.kakaofriendshop.demo.domain;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * User Entity
 *
 */

public class User {
	@NotEmpty(message="아이디를 입력하세요.")
	String id;
	
	@NotEmpty(message="비밀번호를 입력하세요.")
	String password;
	
	@NotEmpty(message="이름을 입력하세요.")
	String name;
	
	@NotEmpty(message="이메일을 입력하세요.")
	@Email(message="이메일 형식이 올바르지 않습니다.")
	String email;
	
	String image;
	Date reg_date;
	
	@NotEmpty(message="휴대폰 번호를 입력하세요.")
	String phone_number;
	
	@NotEmpty(message="주소를 입력하세요.")
	String address;
	
	/**
	 * Id getter, setter
	 */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Password getter, setter
	 */
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Name getter, setter
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Email getter, setter
	 */
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Image getter, setter
	 */
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	 * Phone_number getter, setter
	 */
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	/**
	 * Address getter, setter
	 */
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
}
