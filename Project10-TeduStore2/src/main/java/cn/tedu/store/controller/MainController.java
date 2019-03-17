package cn.tedu.store.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.service.IGoodsCategoryService;

//@RequestMapping("main"): 此为二级路径
@Controller
public class MainController {
	@Resource
	private IGoodsCategoryService iGoodsCategoryService ;
	@RequestMapping("/showIndex.do")
	public String showIndex(ModelMap map) {
		System.out.println("显示商品页面");
		//1,调用业务层方法,获取返回的集合,获取二级分类商品的对象
		List<GoodsCategory>computerList=
				iGoodsCategoryService.getCategoryByParentId(161,0,3);
		//2.创建一个新的集合category161List,
		//编历二级分类集合分类,放到category161List里面,作为三级菜单
		List<List<GoodsCategory>>category161List=
				new ArrayList<List<GoodsCategory>>();
		for(GoodsCategory goods:computerList) {
			//查询出二级菜单中全部内容
			category161List.add(iGoodsCategoryService.getCategoryByParentId(goods.getId(),null,null));
		}
		//3,这两个集合放到map中
		map.addAttribute("computerList",computerList);
		map.addAttribute("category161List",category161List);
		//4
		//设置热门商品到map中
				List<Goods> goodsList = 
						iGoodsCategoryService.getGoodsByCategoryId(163, 0,3);
				map.addAttribute("goodsList",goodsList);
		return "index";
	}
	@RequestMapping("/showPersonal_password.do")
	public String personal_password() {
		
		return "personal_password";
	}

}
