package cn.tedu.store.controller;
 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.service.IGoodsCategoryService;

@Controller
public class GoodsController {
	@Resource
	private IGoodsCategoryService iGoodsCategoryService ;
	
	@RequestMapping("/showSearch.do")
	public String showSearch( Integer page,ModelMap map,Integer categoryId) {
	 
		//
		if(page==null) {
			page=1;
		}
		//偏移量的计算
		int offset=(page-1)*12;
		 List<Goods>goodsList=
				 iGoodsCategoryService.getGoodsByCategoryId(categoryId,offset,12);
		//
		 Integer counts=iGoodsCategoryService.getGoodsCount(categoryId);
		 int pages= counts%12==0 ? counts/12:counts/12+1;
		 map.addAttribute("pages",pages);
		 //在map中设置记录数
		 map.addAttribute("categoryId",categoryId);
		 map.addAttribute("count",counts);
		 map.addAttribute("goodsList", goodsList);
		 //当前页样式显示
		 map.addAttribute("currentpage",page);
		return "search";
	}
	//跳转到商品详情列表
	@RequestMapping("/goodsInfo.do")
	public String goodsInfo(String goodsId,
			Integer categoryId,ModelMap map){
		//查询该分类的热门商品4个
		List<Goods> goodsList=
				iGoodsCategoryService.getGoodsByCategoryId(categoryId,0,4);
		for(Goods go:goodsList) {
			System.out.println(go.getTitle()+","+go.getImage());
			System.out.println("//查询该分类的热门商品4个");
		}
		//把goodsList设置到map中
		map.addAttribute("goodsList",goodsList);
		//把通过商品ID获取goods对象设置到map中
		map.addAttribute("goods",
				iGoodsCategoryService.getGoodsByGoodsId(goodsId));
		return "product_details";
	}
	
	
}
