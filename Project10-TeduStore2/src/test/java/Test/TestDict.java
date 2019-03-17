package Test;
 
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.mapper.DictMapper;

public class TestDict {
/**
 * t_dict_areas,//区
 * t_dict_cities,//市
 * t_dict_provinces,//省
 * 
 */
	@Test
	public void testDict4() {
		ApplicationContext ac=
				new ClassPathXmlApplicationContext("spring-dao.xml");
		DictMapper dictMapper= ac.getBean("dictMapper",DictMapper.class);
		System.out.println("Province:"+dictMapper.selectProvinceNameByCode("110000"));
		System.out.println("City:"+dictMapper.selectCityNameByCode("230300"));
		System.out.println("Area:"+dictMapper.selectArea("230302"));
	}		
	@Test
	public void testDict3() {
		ApplicationContext ac=
				new ClassPathXmlApplicationContext("spring-dao.xml");
		DictMapper dictMapper= ac.getBean("dictMapper",DictMapper.class);
		List<Area>area=dictMapper.selectArea("411600");
		System.out.println(area);
		
		
	}
	@Test
	public void testDict2() {
		ApplicationContext ac=
				new ClassPathXmlApplicationContext("spring-dao.xml");
		DictMapper dictMapper= ac.getBean("dictMapper",DictMapper.class);
		List<City>city=dictMapper.selectCity("130000");
		System.out.println(city);
	}
	@Test
	public void testDict() {
		ApplicationContext ac=
				new ClassPathXmlApplicationContext("spring-dao.xml");
		DictMapper dictMapper= ac.getBean("dictMapper",DictMapper.class);
		List<Province> province=dictMapper.selectProvince();
		for(Province pro:province){
			System.out.println(pro.getProvinceCode()+","+pro.getProvinceName());
		}
		
	}
		
		
		
		
}
