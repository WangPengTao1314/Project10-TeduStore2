package cn.tedu.store.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.ICartService;
/**
 * 添加购物车操作
 * @author soft01
 */
@Controller
public class CartController extends BaseController {
	@Resource 
	private ICartService iCartService;
	
	@RequestMapping("/showCart.do")
	public String showCart() {
		System.out.println("显示添加购物车页面");
		return "cart";
	}
	@RequestMapping("/addCart.do")
	@ResponseBody
	public ResponseResult<Void>addCart(HttpSession session,
			String goodsId,Integer count){
		System.out.println("666:"+goodsId);
		ResponseResult<Void>rr=new ResponseResult<Void>();
		Cart cart= new Cart();
		cart.setUid(getID(session));
		cart.setGoodsId(goodsId);
		cart.setCount(count);
		iCartService.addCart(cart);
		rr.setState("1");
		rr.setMessage("添加购物车成功!");
		return rr;
	}
	@RequestMapping("/getGoods.do")
	public String getGoodsFromCart(HttpSession session,ModelMap map){
		System.out.println(getID(session));
		map.addAttribute("cartList",iCartService.getGoodsByList(getID(session)));
		return "cart";
	}
	
	
	
	

}
