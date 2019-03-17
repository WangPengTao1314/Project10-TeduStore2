package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

public interface DictMapper {
	/**
	 * 查询省信息,封装成Province对象t_dict_provinces
	 * 返回list
	 * @return
	 */
	public List<Province> selectProvince();
	/**
	 * 查询市信息,封装成City对象t_dict_cities
	 * 返回list
	 * @return
	 */
	public List<City> selectCity(String provinceCode);
	/**
	 * 封装县(区)的信息,......
	 * @param AreaCode
	 * @return
	 */
	public List<Area>selectArea(String cityCode);
	/**
	 * 根据provinceCode来查询省名
	 */
	public String selectProvinceNameByCode(String provinceCode);
	/**
	 * 根据cityCode来查询市名
	 * @param cityCode
	 * @return
	 */
	public String selectCityNameByCode(String cityCode);
	/**
	 * 根据areaCode来查询县区名
	 * @param areaCode
	 * @return
	 */
	public String  selectAreaNameByCode(String areaCode);
	
	
}
