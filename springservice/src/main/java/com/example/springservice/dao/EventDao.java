/**
 * All rights reserved by YSCompany Inc.
 */
package com.example.springservice.dao;



import com.example.springpublic.entity.Event;
import org.springframework.stereotype.Repository;

/**
 * Mapper.<p>
 * @author WillYang
 * @Date 2021-08-19 17:37:57
 * @since 1.0
 */
@Repository
public interface EventDao {

	static String SEQUENCE = "SEQ_event_ID";
	
	/**
	 * 创建对象
	 * @param event
	 * @return
	 * @author WillYang
	 * @since 2021-08-19 17:37:57
	 */
	public int create(Event event);
	
	
	/**
	 * 根据主键查询对象
	 * @param eventId
	 * @return
	 * @author WillYang
	 * @since 2021-08-19 17:37:57
	 */
	public Event queryByPk(Integer eventId);
	
	/**
	 * 根据主键修改对象
	 * @param event
	 * @return
	 * @author WillYang
	 * @since 2021-08-19 17:37:57
	 */
	public int updateByPk(Event event);
	
	/**
	 * 根据主键删除对象
	 * @param eventId
	 * @return
	 * @author WillYang
	 * @since 2021-08-19 17:37:57
	 */
	public int deleteByPk(Integer eventId);

	
	/**
	 * 根据对象查询数据
	 * @param event
	 * @return
	 * @author WillYang
	 * @since 2021-08-19 17:37:57
	 */
	public java.util.List<Event> queryByEvent(Event event);
	
	/**
	 * 根据条件分页查询数据
	 * @param paramMap
	 * @return
	 * @author WillYang
	 * @since 2021-08-19 17:37:57
	 */
	@SuppressWarnings({"rawtypes" })
	public java.util.List<Event> queryByPage(java.util.Map paramMap);

	/**
	 * 根据条件查询数据总量
	 * @param paramMap
	 * @return
	 * @author WillYang
	 * @since 2021-08-19 17:37:57
	 */
	@SuppressWarnings({"rawtypes" })
	public long countByCondtion(java.util.Map paramMap);
}
