package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;
import cn.tedu.store.mapper.CartMapper;

@Service
public class CartService implements ICartService{
	@Resource(name="cartMapper")
	private CartMapper cartMapper;
	
	public void addCart(Cart cart) {
		cartMapper.insertCart(cart);
	}
	/**
	 * 返回购物车中的商品中列表
	 */
	public List<CartVo> getGoodsByList(Integer uid) {
		 
		return cartMapper.selectCartByUid(uid);
	}

}
