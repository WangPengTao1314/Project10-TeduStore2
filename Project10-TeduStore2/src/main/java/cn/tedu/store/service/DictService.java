package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.mapper.DictMapper;
@Service
public class DictService implements IDictService{

	@Resource(name="dictMapper")
	private DictMapper dictMapper;
	/**
	 * 返回list集合
	 */
	public List<Province> getProvince() {	 
		return dictMapper.selectProvince();
	}
	/**
	 * 
	 */
	public List<City> getCity(String provinceCode) {	 
		return dictMapper.selectCity(provinceCode);
	}
	/**
	 * 传送
	 */
	public List<Area> getArea(String cityCode) { 
		return dictMapper.selectArea(cityCode);
	}
	/**
	 * 返回省名;
	 */
	public String getProvinceByName(String provinceCode) {
		return dictMapper.selectProvinceNameByCode(provinceCode);
	}
	public String getCityByName(String cityCode) {
		 
		return dictMapper.selectCityNameByCode(cityCode);
	}
	public String getAreaByName(String areaCode) {
		 
		return dictMapper.selectAreaNameByCode(areaCode);
	}
	

}
