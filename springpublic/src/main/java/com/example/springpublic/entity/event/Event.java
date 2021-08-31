/**
 * All rights reserved by YSCompany Inc.
 */
package com.example.springpublic.entity.event;


/**
 * <p>
 * @author WillYang
 * @Date 2021-08-19 17:37:57
 * @since 1.0
 */
public class Event {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** . */
	private Integer eventId ;
	
	/** . */
	private String eventName ;
	
	/** . */
	private Integer parentId ;
	
	/** . */
	private String userCode ;

	/** . */
	private String userName ;
	
	/** . */
	private String status ;
	
	/** . */
	private java.util.Date createTime ;
	
	/** . */
	private java.util.Date updateTime ;
	
	/** . */
	private String type ;
	
	/** . */
	private String sort ;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/** set . */
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	
	/** get . */
	public Integer getEventId() {
		return this.eventId;
	}
	

    /** set . */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	/** get . */
	public String getEventName() {
		return this.eventName;
	}
	

    /** set . */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	/** get . */
	public Integer getParentId() {
		return this.parentId;
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
	public void setStatus(String status) {
		this.status = status;
	}
	
	/** get . */
	public String getStatus() {
		return this.status;
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
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
	
	/** get . */
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}
	

    /** set . */
	public void setType(String type) {
		this.type = type;
	}
	
	/** get . */
	public String getType() {
		return this.type;
	}
	

    /** set . */
	public void setSort(String sort) {
		this.sort = sort;
	}
	
	/** get . */
	public String getSort() {
		return this.sort;
	}
	
}

