
/**
 * All rights reserved by YSCompany Inc.
 */
package com.example.springservice.dao;




import com.example.springpublic.entity.event.EventUser;
import org.springframework.stereotype.Repository;

/**
 * Mapper.<p>
 * @author WillYang
 * @Date 2021-08-23 18:40:56
 * @since 1.0
 */
@Repository
public interface EventUserMapper {

	static String SEQUENCE = "SEQ_event_user_ID";

	/**
	 * 创建对象
	 * @param eventUser
	 * @return
	 * @author WillYang
	 * @since 2021-08-23 18:40:56
	 */
	public int create(EventUser eventUser);


	/**
	 * 根据主键查询对象
	 * @param userCode
	 * @return
	 * @author WillYang
	 * @since 2021-08-23 18:40:56
	 */
	public EventUser queryByPk(java.lang.String userCode);

	/**
	 * 根据主键修改对象
	 * @param eventUser
	 * @return
	 * @author WillYang
	 * @since 2021-08-23 18:40:56
	 */
	public int updateByPk(EventUser eventUser);

	/**
	 * 根据主键删除对象
	 * @param userCode
	 * @return
	 * @author WillYang
	 * @since 2021-08-23 18:40:56
	 */
	public int deleteByPk(java.lang.String userCode);


	/**
	 * 根据对象查询数据
	 * @param eventUser
	 * @return
	 * @author WillYang
	 * @since 2021-08-23 18:40:56
	 */
	public java.util.List<EventUser> queryByEventUser(EventUser eventUser);

	/**
	 * 根据条件分页查询数据
	 * @param paramMap
	 * @return
	 * @author WillYang
	 * @since 2021-08-23 18:40:56
	 */
	@SuppressWarnings({"rawtypes" })
	public java.util.List<EventUser> queryByPage(java.util.Map paramMap);

	/**
	 * 根据条件查询数据总量
	 * @param paramMap
	 * @return
	 * @author WillYang
	 * @since 2021-08-23 18:40:56
	 */
	@SuppressWarnings({"rawtypes" })
	public long countByCondtion(java.util.Map paramMap);
}
