package Test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.mapper.GoodsCategoryMapper;
import cn.tedu.store.mapper.GoodsMapper;
import cn.tedu.store.service.IGoodsCategoryService;

public class GoodsTest {
	/*~~~~~~~~~~~~~~~~持久层~~~~~~~~~~~~~~~~~*/
	@Test
	public void testMapper4() {
		ApplicationContext ac=
				new ClassPathXmlApplicationContext("spring-dao.xml");
		GoodsMapper goods=ac.getBean("goodsMapper",GoodsMapper.class);
		System.out.println(goods.selectByGoodsId("10000043"));
	}
	@Test
	public void testMapper3() {
		ApplicationContext ac=
				new ClassPathXmlApplicationContext("spring-dao.xml");
		GoodsMapper goods=ac.getBean("goodsMapper",GoodsMapper.class);
		System.out.println(goods.selectGoodsCount(163));
	}
	@Test
	public void testMapper2() {
		ApplicationContext ac=
				new ClassPathXmlApplicationContext("spring-dao.xml");
		GoodsMapper goods=ac.getBean("goodsMapper",GoodsMapper.class);
		System.out.println(goods.selectGoodsByCategoryId(163,0,3));		
				
	}
	@Test
	public void testMapper() {
		ApplicationContext ac= 
				new ClassPathXmlApplicationContext("spring-dao.xml");
	GoodsCategoryMapper goods=
			ac.getBean("goodsCategoryMapper",GoodsCategoryMapper.class);
	//电脑办公一级分类 id=161
	// 二级菜单id:162 ,171 ,186,
	System.out.println(goods.selectCategoryByParentId(171,0,5));
	
	}
	
	/*~~~~~~~~~~~~~~~~业务层~~~~~~~~~~~~~~~~~*/
	@Test
	public void testService() {
		ApplicationContext ac= 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IGoodsCategoryService ics=
				ac.getBean("iGoodsCategoryService",IGoodsCategoryService.class);
		System.out.println(ics.getCategoryByParentId(161,null,null));
		
	}
	@Test
	public void testService2() {
		ApplicationContext ac= 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IGoodsCategoryService ics=
				ac.getBean("iGoodsCategoryService",IGoodsCategoryService.class);
		System.out.println(ics.getGoodsByGoodsId("10000043"));
		
	}
	
}
