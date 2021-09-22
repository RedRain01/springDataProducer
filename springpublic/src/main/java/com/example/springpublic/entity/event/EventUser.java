/**
 * All rights reserved by YSCompany Inc.
 */
package com.example.springpublic.entity.event;


import java.util.Date;

/**
 * <p>
 * @author WillYang
 * @Date 2021-08-23 17:53:32
 * @since 1.0
 */
public class EventUser {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** . */
	private String userName ;
	
	/** . */
	private String userCode ;
	
	/** . */
	private String phone ;
	
	/** . */
	private java.util.Date createTime ;
	
	/** . */
	private String status ;
	
	/**  本质. */
	private String nature ;
	
	/** . */
	private String password ;

	public EventUser(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public EventUser() {
	}

	/** set . */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/** get . */
	public String getUserName() {
		return this.userName;
	}
	

    /** set . */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	/** get . */
	public String getUserCode() {
		return this.userCode;
	}
	

    /** set . */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/** get . */
	public String getPhone() {
		return this.phone;
	}
	

    /** set . */
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	/** get . */
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	

    /** set . */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/** get . */
	public String getStatus() {
		return this.status;
	}
	

    /** set  本质. */
	public void setNature(String nature) {
		this.nature = nature;
	}
	
	/** get  本质. */
	public String getNature() {
		return this.nature;
	}
	

    /** set . */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/** get . */
	public String getPassword() {
		return this.password;
	}
	
}

