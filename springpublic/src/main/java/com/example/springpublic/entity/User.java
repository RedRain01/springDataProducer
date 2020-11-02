/**
 * All rights reserved by YSCompany Inc.
 */
package com.example.springpublic.entity;


/**
 * <p>
 * @author WillYang
 * @Date 2020-10-04 12:22:33
 * @since 1.0
 */
public class User {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/**  用户名. */
	private String userName ;
	
	/** 用户id. */
	private String userId ;
	
	/** 手机. */
	private String phone ;
	
	/** 地址. */
	private String addr ;
	
	/** 邮箱. */
	private String email ;
	
	/** 等级. */
	private String grade ;
	
	

    /** set  用户名. */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/** get  用户名. */
	public String getUserName() {
		return this.userName;
	}
	

    /** set 用户id. */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/** get 用户id. */
	public String getUserId() {
		return this.userId;
	}
	

    /** set 手机. */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/** get 手机. */
	public String getPhone() {
		return this.phone;
	}
	

    /** set 地址. */
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	/** get 地址. */
	public String getAddr() {
		return this.addr;
	}
	

    /** set 邮箱. */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/** get 邮箱. */
	public String getEmail() {
		return this.email;
	}
	

    /** set 等级. */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	/** get 等级. */
	public String getGrade() {
		return this.grade;
	}
	
}

