package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

public interface IDictService {
	/**
	 * 返回持久层(省)集合
	 * @return
	 */
	public List<Province>getProvince();
	/*
	 * 返回持久层(市)集合
	 */
	public List<City>getCity(String provinceCode);
	/**
	 * 返回持久层(县或区)集合
	 * @param cityCode
	 * @return
	 */
	public List<Area>getArea(String cityCode);
	/**
	 * 根据provinceCode获取省名
	 * @param provinceCode
	 * @return
	 */
	public String getProvinceByName (String provinceCode);
	/**
	 * 根据cityCode获取 cityName
	 * @param cityCode
	 * @return
	 */
	public String getCityByName (String cityCode);
	/**
	 * 根据provinceCode获取省名
	 * @param areaCode
	 * @return
	 */
	public String getAreaByName (String areaCode);
}
