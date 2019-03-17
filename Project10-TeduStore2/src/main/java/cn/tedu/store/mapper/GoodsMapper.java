package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Goods;

public interface GoodsMapper {
	/**
	 * 通过categoryId来查询热门商品列表
	 * @param categoryId
	 * @param offset
	 * @param count
	 * @return
	 */
	public List<Goods>selectGoodsByCategoryId(
			@Param("categoryId") Integer categoryId,
			@Param("offset")Integer offset,
			@Param("count") Integer count);

	/**
	 * 
	 * @param categoryId
	 * @return
	 */
	public Integer selectGoodsCount(Integer categoryId);
	/**
	 * 通过id查询商品详情信息
	 * @param id
	 * @return
	 */
	public Goods selectByGoodsId(String goodsId);
	
	
	
	
}
