package Test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;
import cn.tedu.store.mapper.CartMapper;

public class TestCart {
	
	@Test
	public void testCart() {
		ApplicationContext ac= 
				new ClassPathXmlApplicationContext("spring-dao.xml");
		CartMapper cartMapper= ac.getBean("cartMapper",CartMapper.class);
		Cart cart= new Cart();
		cart.setUid(1);
		cart.setGoodsId("123456");
		cart.setCount(5);
		cart.setCreatedUser("王朋涛");
		cart.setCreatedTime(new Date());
		cart.setModifiedUser(null);
		cart.setModifiedTime(null);
		cartMapper.insertCart(cart);
		System.out.println("插入成功!");
	}
	@Test
	public void testCart2() {
		ApplicationContext ac= 
				new ClassPathXmlApplicationContext("spring-dao.xml");
		CartMapper cartMapper= ac.getBean("cartMapper",CartMapper.class);
		List<CartVo>list=cartMapper.selectCartByUid(1);
		System.out.println("list:"+list);
		
	}
	
	
	
	
	
	

}
