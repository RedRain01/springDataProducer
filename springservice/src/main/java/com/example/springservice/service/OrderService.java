/**
 * All rights reserved by YSCompany Inc.
 */
package com.example.springservice.service;



import com.example.springpublic.entity.Order;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Mapper.<p>
 * @author WillYang
 * @Date 2020-10-04 12:22:34
 * @since 1.0
 */


public interface OrderService {

	static String SEQUENCE = "SEQ_order_ID";
	
	/**
	 * 创建对象
	 * @param order
	 * @return
	 * @author WillYang
	 * @since 2020-10-04 12:22:34
	 */
	public int create(Order order);
	
	
	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @author WillYang
	 * @since 2020-10-04 12:22:34
	 */
	public Order queryByPk(String id);
	
	/**
	 * 根据主键修改对象
	 * @param order
	 * @return
	 * @author WillYang
	 * @since 2020-10-04 12:22:34
	 */
	public int updateByPk(Order order);
	
	/**
	 * 根据主键删除对象
	 * @param id
	 * @return
	 * @author WillYang
	 * @since 2020-10-04 12:22:34
	 */
	public int deleteByPk(String id);

	
	/**
	 * 根据对象查询数据
	 * @param order
	 * @return
	 * @author WillYang
	 * @since 2020-10-04 12:22:34
	 */
	public java.util.List<Order> queryByOrder(Order order);
	
	/**
	 * 根据条件分页查询数据
	 * @param paramMap
	 * @return
	 * @author WillYang
	 * @since 2020-10-04 12:22:34
	 */
	@SuppressWarnings({"rawtypes" })
	public java.util.List<Order> queryByPage(java.util.Map paramMap);

	/**
	 * 根据条件查询数据总量
	 * @param paramMap
	 * @return
	 * @author WillYang
	 * @since 2020-10-04 12:22:34
	 */
	@SuppressWarnings({"rawtypes" })
	public long countByCondtion(java.util.Map paramMap);

	public long maxId();

	public ArrayList<String> allPort();


}
