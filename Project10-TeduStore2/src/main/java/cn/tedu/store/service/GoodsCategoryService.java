package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.mapper.GoodsCategoryMapper;
import cn.tedu.store.mapper.GoodsMapper;
@Service("iGoodsCategoryService")
public class GoodsCategoryService implements IGoodsCategoryService{

	@Resource(name="goodsCategoryMapper")
	private GoodsCategoryMapper goodsCategoryMapper;
	@Resource(name="goodsMapper")
	private GoodsMapper goodsMapper;
	/**
	 * 返回商品分类列表
	 */
	public List<GoodsCategory> getCategoryByParentId
		(Integer parentId, Integer offset, Integer count) {
 		return goodsCategoryMapper.selectCategoryByParentId(parentId, offset, count);
	}
    /**
     * 返回热门商品的分类列表
     */
	public List<Goods> getGoodsByCategoryId
		(Integer categoryId, Integer offset, Integer count) {
 		return goodsMapper.selectGoodsByCategoryId(categoryId, offset, count);
	}
	/*
	 * 返回热门商品的数目
	 * 
	 */
	public Integer getGoodsCount(Integer categoryId) {
		return goodsMapper.selectGoodsCount(categoryId);
	}
	/**
	 * 查询商品的详情信息
	 */
	public Goods getGoodsByGoodsId(String goodsId) {
		 return goodsMapper.selectByGoodsId(goodsId);
	}

}
