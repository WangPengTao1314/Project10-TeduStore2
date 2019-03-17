package cn.tedu.store.mapper;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.User;

/**
 * 持久成
 *  用户管理层模块的数据库操作
 */
public interface UserMapper {
	void updateImageById(@Param("image")String image,
			@Param("id")	Integer id);
	/*
	 * 项数据库插入数据
	 */
	public void insert(User user);
	 
	/**
	 * 通过用户名查询数据库用户名
	 * @param username
	 * @return
	 */
	public User select(String username);
	 
	/**
	 * 验证邮箱是否存在,若存在则返回1,不存在返回0;
	 * @param email
	 * @return
	 */
	public Integer selectByEmail(String email);
	/**
	 * 验证电话是否存在,若存在则返回1,不存在返回0;
	 * @param phone
	 * @return
	 */
	 public Integer selectByPhone(String phone);
	 /**
	  * 实现用户信息的动态修改
	  * @param id
	  */
	 public void update(User user);
	 /**
	  *  通过ID查询有返回user,无返回null
	  * @param id
	  * @return
	  */
	 public User selectById(Integer id);
	 
	 
}
