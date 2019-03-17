package cn.tedu.store.service;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.ex.ClassNameAlreadyException;
import cn.tedu.store.service.ex.PasswordNotFoundException;
import cn.tedu.store.service.ex.UserNameNotFoundException;

@Service("iUserService")
public class UserService implements IUserService {
	@Resource(name = "userMapper")
	private UserMapper userMapper;
	/**
	 * 利用消息摘要加密
	 */
	@Value("#{dbConfig.salt}")
	private String salt;
	public void register(User user) {
		/*
		 * 验证用户名是否存在!
		 * 
		 */
		if (userMapper.select(user.getUsername()) == null) {
			
			 
			String newp=DigestUtils.md5Hex(user.getPassword()+salt);
			user.setPassword(newp);
			userMapper.insert(user);
		} else {
			throw new ClassNameAlreadyException("用户名已存在!");
		}
	}

	public boolean checkEmail(String email) {
		/*
		 * 若邮箱存在者返回true,否者返回true;
		 */
		/*
		 * if(userMapper.selectByEmail(email)==0) { return false; }else { return true; }
		 */
		return userMapper.selectByEmail(email) > 0;
	}

	public boolean checkPhone(String phone) {
		/**
		 * 验证邮箱是否存在?,若存在则返回true;否者返回false; 即如郭存在相同的电话是不能进行注册
		 */
		return userMapper.selectByPhone(phone) > 0;
	}

	/**
	 * 验证用户名是否存在
	 */
	public boolean checkName(String username) {
		User user = userMapper.select(username);
		if (user == null) {

			return false;
		} else {
			return true;
		}
	}

	/* ~~~~~~~~~~~~~~~~~登陆验证~~~~~~~~~~~~~~~~~~ */
	/**
	 * 登陆验证,先验证用户名和再验证密码 测试?
	 * 
	 */
	public User login(String username, String password) {
		User user = userMapper.select(username);
		if (user == null) {
			throw new UserNameNotFoundException("用户不存在!");
		} else {
		 
			String newp=DigestUtils.md5Hex(password+salt);
			if (user.getPassword().equals(newp)) {
				return user;
			} else {
				throw new PasswordNotFoundException("密码错误!");
			}
		}
	}

	/* ~~~~~~~~~~~~~~~验证并修改密码~~~~~~~~~~~~~~~~~~~~~~ */
	public void changePassword(Integer id, String oldPwd, String newPwd) {
		User user = userMapper.selectById(id);
		if (user != null) {
			String newpOpwd=DigestUtils.md5Hex(oldPwd+salt);
			if (user.getPassword().equals(newpOpwd)) {
				User ps = new User();
				ps.setId(id);
				ps.setPassword(DigestUtils.md5Hex(newPwd+salt));
				userMapper.update(ps);
			} else {
				throw new PasswordNotFoundException("旧密码错误!");
			}
		} else {
			throw new UserNameNotFoundException("用户不存在!");
		}

	}

	/* ~~~~~~~~~~~~~~~~~~~~~~~个人信息修改~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	// 用户名的修改
	public void updateUser(Integer id, String username,Integer gender, String phone, String email) {
		User user = new User();
		User u1 = userMapper.select(username);
		if (u1 == null) {
			user.setUsername(username);
		} else {
			User u2 = userMapper.selectById(id);
			if (u2 != null) {
				// 不修改登陆用户名!
				if (u2.getUsername().equals(username)) {
					
				} else {
					throw new ClassNameAlreadyException("用户明已存在!");
				}
			}
		}
		user.setId(id);
		user.setGender(gender);
		user.setPhone(phone);
		user.setEmail(email);
		userMapper.update(user);
	}
	//
	public User getUserById(Integer id) {
		return userMapper.selectById(id);
	}
	/**
	 * 修改用户头像
	 */
	public void getImageById(String image, Integer id) {
		 userMapper.updateImageById(image, id);
	}

}
