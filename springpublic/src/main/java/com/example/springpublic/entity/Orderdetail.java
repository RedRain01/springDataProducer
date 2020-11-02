/**
 * All rights reserved by YSCompany Inc.
 */
package com.example.springpublic.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * @author WillYang
 * @Date 2020-01-15 09:58:21
 * @since 1.0
 */
public class Orderdetail implements Serializable {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** . */
	private String orderid ;
	
	/** . */
	private double price ;
	
	/** . */
	private String cargoNum ;
	
	/** . */
	private Date orderTime ;
	
	/** . */
	private String userCode ;

	/** . */
	private String port ;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}


	public String getCargoNum() {
		return cargoNum;
	}

	public void setCargoNum(String cargoNum) {
		this.cargoNum = cargoNum;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
}

