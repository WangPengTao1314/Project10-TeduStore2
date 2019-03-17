package Test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.IAddressService;

public class TestAddress {
/*~~~~~~~~~~~持久层测试~~~~~~~~~~~~*/
	@Test
	public void testMapper6() {
		ApplicationContext ac= 
				new ClassPathXmlApplicationContext("spring-dao.xml");
		AddressMapper addressMapper=
				ac.getBean("addressMapper",AddressMapper.class);
		addressMapper.deleteById(4);
		System.out.println("删除成功!");
		
	}
	@Test
	public void testMapper5() {
		ApplicationContext ac= 
				new ClassPathXmlApplicationContext("spring-dao.xml");
		AddressMapper addressMapper=
				ac.getBean("addressMapper",AddressMapper.class);
		Address address=new Address();
		address.setRecvName("大王");
		address.setRecvProvince("410000");
		address.setRecvCity("410100");
		address.setRecvArea("410105");
		address.setRecvAddress("周家庄");
		address.setRecvPhone("18866666699");
		address.setId(1);
		addressMapper.updateById(address);
		System.out.println("修改成功!");
		
	}
	@Test
	public void testMapper4() {
		ApplicationContext ac= 
				new ClassPathXmlApplicationContext("spring-dao.xml");
		AddressMapper addressMapper=
				ac.getBean("addressMapper",AddressMapper.class);
		Address address=addressMapper.selectAddressById(1);
		System.out.println("address:"+address);
	}
	@Test
	public void testMapper3() {
		ApplicationContext ac= 
				new ClassPathXmlApplicationContext("spring-dao.xml");
		AddressMapper addressMapper=
				ac.getBean("addressMapper",AddressMapper.class);
		System.out.println(addressMapper.yesIsDefault(1));
		//System.out.println(addressMapper.noIsDefault(1));
	}
	@Test
	public void testMapper2() {
		ApplicationContext ac= 
				new ClassPathXmlApplicationContext("spring-dao.xml");
		AddressMapper addressMapper=ac.getBean("addressMapper",AddressMapper.class);
		System.out.println(addressMapper.selectAddressByUid(1));
		
	}
	@Test
	public void testMapper1() {
		ApplicationContext ac= 
				new ClassPathXmlApplicationContext("spring-dao.xml");
		AddressMapper addressMapper=ac.getBean("addressMapper",AddressMapper.class);
		Address address=new Address();
		address.setUid(2);
		address.setRecvName("苏轼");
		address.setRecvProvince("650000");//省
		address.setRecvCity("659000");//市
		address.setRecvArea("659001");//县
		address.setRecvDistrict("xxxxoooo");//区
		address.setRecvAddress("xxxxoooo");//详细地址
		address.setRecvPhone("15552152152");
		addressMapper.insert(address);
		System.out.println("插入成功!");
		
	}
	
	
	//保留字goto, const
	
	
/*~~~~~~~~~~~业务层测试~~~~~~~~~~~~~*/	
	@Test
	public void testService4() {
		ApplicationContext ac= 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
	IAddressService iAddressService=ac.getBean(IAddressService.class);
	Address address= new Address();
	address.setId(1);
	address.setRecvName("数小妹");
	address.setRecvProvince("650000");//省
	address.setRecvCity("659000");//市
	address.setRecvArea("659001");//县
	//address.setRecvDistrict("xxxxoooo");//区
	address.setRecvAddress("xxxxoooo");//详细地址
	address.setRecvPhone("15552152152");
	iAddressService.updateAddressById(address);
	System.out.println("修改成功");
	}
	@Test
	public void testService() {
		ApplicationContext ac= 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
	IAddressService iAddressService=ac.getBean(IAddressService.class);
	Address address= new Address();
	address.setUid(1);
	address.setRecvName("数小妹");
	address.setRecvProvince("650000");//省
	address.setRecvCity("659000");//市
	address.setRecvArea("659001");//县
	address.setRecvDistrict("xxxxoooo");//区
	address.setRecvAddress("xxxxoooo");//详细地址
	address.setRecvPhone("15552152152");
	iAddressService.saveAddress(address);
	System.out.println("保存成功!");
	
	}
	@Test
	public void testService2() {
		ApplicationContext ac= 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IAddressService iAddress= 
				ac.getBean("addressService",IAddressService.class);
		System.out.println
					("list:"+iAddress.returnAddressList(2));
	
	}
	@Test
	public void testService3() {
		ApplicationContext ac= 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IAddressService iAddress= 
				ac.getBean("addressService",IAddressService.class);
		iAddress.setisDefault(1,2);
		System.out.println("!!!");
	}
	@Test
	public void testService5() {
		ApplicationContext ac= 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IAddressService iAddress= 
				ac.getBean("addressService",IAddressService.class);
		iAddress.deleteAddressById(3);
		System.out.println("删除成功!");
		
	}

}
