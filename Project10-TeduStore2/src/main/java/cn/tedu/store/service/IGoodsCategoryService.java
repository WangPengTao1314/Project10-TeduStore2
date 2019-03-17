package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;

public interface IGoodsCategoryService {
	/**
	 * 根据parentId查询商品分类列表
	 * @param parentId
	 * @param offset
	 * @param count
	 * @return
	 */
	public List<GoodsCategory>getCategoryByParentId
			(Integer parentId,Integer offset,Integer count);
	/**
	 * 通过categoryId来查询热门商品列表
	 * @param categoryId
	 * @param offset
	 * @param count
	 * @return
	 */
	public List<Goods>getGoodsByCategoryId
			(Integer categoryId,Integer offset,Integer count);
	/**
	 * 返回商品数目
	 * @param parentId
	 * @return
	 */
	public Integer getGoodsCount(Integer categoryId);
	/**
	 * 获取商品详情信息列表
	 * @param id
	 * @return
	 */
	public Goods getGoodsByGoodsId(String goodsId);

}
