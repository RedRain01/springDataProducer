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
public class Commodity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 商品名称. */
	private String commodityName ;
	
	/** 商品颜色. */
	private String commodityColour ;
	
	/** 商品号. */
	private String commodityNo ;
	
	/** 单价. */
	private Double amount ;
	
	/** 描述. */
	private String description ;
	
	

    /** set 商品名称. */
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	
	/** get 商品名称. */
	public String getCommodityName() {
		return this.commodityName;
	}
	

    /** set 商品颜色. */
	public void setCommodityColour(String commodityColour) {
		this.commodityColour = commodityColour;
	}
	
	/** get 商品颜色. */
	public String getCommodityColour() {
		return this.commodityColour;
	}
	

    /** set 商品号. */
	public void setCommodityNo(String commodityNo) {
		this.commodityNo = commodityNo;
	}
	
	/** get 商品号. */
	public String getCommodityNo() {
		return this.commodityNo;
	}
	

    /** set 单价. */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	/** get 单价. */
	public Double getAmount() {
		return this.amount;
	}
	

    /** set 描述. */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/** get 描述. */
	public String getDescription() {
		return this.description;
	}
	
}

