package cn.tedu.store.service;

import cn.tedu.store.bean.User;

public interface IUserService {
	/**
	 * 通过ID修改Image信息
	 * @param image
	 * @param id
	 */
	public void getImageById(String image,Integer id);
	//验证姓名
	public void register(User user);
	//验证邮箱
	public boolean checkEmail(String email);
	//验证电话号码
	public boolean checkPhone(String phone);
	//验证用户名
	public boolean checkName(String name);
	//用户登陆
	public User login(String username,String password);
	//验证并修改密码
	public void changePassword(Integer id,String oldPwd,String newPwd);
	/**
	 * 修改用户信息
	 * @param id
	 * @param username
 
	 * @param gender
	 * @param phone
	 * @param email
	 */
	public void updateUser(Integer id,String username ,Integer gender,String phone,String email);
	/**
	 * 通过ID获取user对象
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id);
	
	
	
	
	
}
