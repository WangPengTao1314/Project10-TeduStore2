package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;
 
import cn.tedu.store.bean.User;
/**
 * 用于获取登陆用户的ID 
 * @author soft01
 *
 */
public class BaseController {

	public Integer getID(HttpSession session) {
		User user=(User)session.getAttribute("user");
		Integer id=null;
		//验证是否为空
		if(user!=null) {
			id=user.getId();
			return id;
		}
		return null;
	}

}
