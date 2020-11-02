/**
 * All rights reserved by YSCompany Inc.
 */
package com.example.springpublic.entity;


/**
 * <p>
 * @author WillYang
 * @Date 2020-10-04 12:22:34
 * @since 1.0
 */
public class Order {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 订单号
            订单时间
            商品号
            用户号
            数量
            金额
            支付状态
            手机号
            地址
            订单标记
            . */
	private String id ;
	
	/** 商品号. */
	private String commodityId ;
	
	/** 数量. */
	private Integer orderNum ;
	
	/** 用户号. */
	private String usercode ;
	
	/** 支付状态. */
	private String status ;
	
	/** 金额. */
	private Double amount ;
	
	/** 手机号. */
	private String phoneNum ;
	
	/** 订单时间. */
	private java.util.Date createTime ;
	
	/** 地址. */
	private String addr ;
	
	/** 订单标记. */
	private String orderFlag ;


	

    /** set 订单号
            订单时间
            商品号
            用户号
            数量
            金额
            支付状态
            手机号
            地址
            订单标记
            . */
	public void setId(String id) {
		this.id = id;
	}
	
	/** get 订单号
            订单时间
            商品号
            用户号
            数量
            金额
            支付状态
            手机号
            地址
            订单标记
            . */
	public String getId() {
		return this.id;
	}
	

    /** set 商品号. */
	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}
	
	/** get 商品号. */
	public String getCommodityId() {
		return this.commodityId;
	}
	

    /** set 数量. */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	
	/** get 数量. */
	public Integer getOrderNum() {
		return this.orderNum;
	}
	

    /** set 用户号. */
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	
	/** get 用户号. */
	public String getUsercode() {
		return this.usercode;
	}
	

    /** set 支付状态. */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/** get 支付状态. */
	public String getStatus() {
		return this.status;
	}
	

    /** set 金额. */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	/** get 金额. */
	public Double getAmount() {
		return this.amount;
	}
	

    /** set 手机号. */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	/** get 手机号. */
	public String getPhoneNum() {
		return this.phoneNum;
	}
	

    /** set 订单时间. */
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	/** get 订单时间. */
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	

    /** set 地址. */
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	/** get 地址. */
	public String getAddr() {
		return this.addr;
	}
	

    /** set 订单标记. */
	public void setOrderFlag(String orderFlag) {
		this.orderFlag = orderFlag;
	}
	
	/** get 订单标记. */
	public String getOrderFlag() {
		return this.orderFlag;
	}
	
}

