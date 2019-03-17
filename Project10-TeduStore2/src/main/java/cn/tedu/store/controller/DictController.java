package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IDictService;

/**
 * 地址管理的控制器
 * 
 * @author soft01
 *
 */
@Controller
public class DictController extends BaseController {

	@Resource 
	private IDictService iDictService;

	@RequestMapping("/showProvince.do")
	@ResponseBody
	public ResponseResult<List<Province>> showProvince() {
		//
		ResponseResult<List<Province>> rr = 
				new ResponseResult<List<Province>>();
		//调用业务层方法
		List<Province> province = iDictService.getProvince();
		//把list对象放到rr对象里面
		rr.setDatap(province);
		//
		return rr;
	}
	
	@RequestMapping("/showCity.do")
	@ResponseBody
	public ResponseResult<List<City>> showCity(String provinceCode){
		//
		ResponseResult<List<City>> rr=new ResponseResult<List<City>>();
		//
		List<City>citys=iDictService.getCity(provinceCode);
		 
		//
		rr.setDatap(citys);
		return rr;
	}
	@RequestMapping("/showArea.do")
	@ResponseBody
	public ResponseResult<List<Area>>showArea(String cityCode){
		ResponseResult<List<Area>> rr=new ResponseResult<List<Area>>();
		//
		List<Area>areas=iDictService.getArea(cityCode);
		//
		rr.setDatap(areas);
		return rr;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
