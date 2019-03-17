package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;

public interface ICartService {
	/**
	 * 
	 * @param uid
	 * @return
	 */
	public List<CartVo>getGoodsByList(Integer uid);
	/**
	 * 传递封装Cart里面的属性
	 * @param cart
	 */
	public void addCart(Cart cart);

}
