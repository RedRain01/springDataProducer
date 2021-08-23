/**
 * All rights reserved by YSCompany Inc.
 */
package com.example.springservice.service;



import com.example.springpublic.entity.event.Event;
import com.example.springpublic.entity.event.EventUser;
import org.springframework.stereotype.Repository;

/**
 * Mapper.<p>
 * @author WillYang
 * @Date 2021-08-19 17:37:57
 * @since 1.0
 */
@Repository
public interface EventUserService {

	static String SEQUENCE = "SEQ_event_ID";
	
	/**
	 * 创建对象
	 * @param eventUser
	 * @return
	 * @author WillYang
	 * @since 2021-08-19 17:37:57
	 */
	public int create(EventUser eventUser);


	/**
	 * 根据对象查询数据
	 * @param eventUser
	 * @return
	 * @author WillYang
	 * @since 2021-08-23 18:40:56
	 */
	public java.util.List<EventUser> queryByEventUser(EventUser eventUser);
	

}
