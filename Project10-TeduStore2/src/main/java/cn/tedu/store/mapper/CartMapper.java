package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;

public interface CartMapper {
	/**
	 * 查询用户的登陆购物车
	 * @param uid
	 * @return
	 */
	public  List<CartVo>selectCartByUid(Integer uid);
	/**
	 * 向购物车表中插入数据
	 * @param cart
	 */
	public void insertCart(Cart cart);
	
	
	

}
