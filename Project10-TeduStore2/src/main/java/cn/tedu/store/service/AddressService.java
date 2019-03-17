package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.mapper.DictMapper;

@Service("addressService")
public class AddressService implements IAddressService {
	
	@Resource(name="dictMapper")
	private DictMapper dictMapper;
	@Resource(name="addressMapper")
	private AddressMapper addressMapper; 
	/**
	 * 保存收获地址
	 */
	public void saveAddress(Address address) {
		/*
		 * 设置省市名称,并把获取的省市县设置到属性recvAddress中
		 */
		address.setRecvDistrict(dictMapper.selectProvinceNameByCode(address.getRecvProvince())+""
				+dictMapper.selectCityNameByCode(address.getRecvCity())+""
				+dictMapper.selectAreaNameByCode(address.getRecvArea()));
		/**
		 * 2.给isDefault设置值
		 *	调用selectByUid方法，该方法返回list
		 *  如果list.size()>0,address的isDefault设置值为0，否则，设置为1
		*/
		List<Address>listAddress=addressMapper.selectAddressByUid(address.getUid());
		if(listAddress.size()>0) {
			address.setIsDefault(0);
		}else {
			address.setIsDefault(1);
		}
		addressMapper.insert(address);
		
	}
	/**
	 * 根据uid查询地址列表
	 */
	public List<Address> returnAddressList(Integer uid) {
		 
		return addressMapper.selectAddressByUid(uid);
	}
	/**
	 * 根据uid ,id设置默认值
	 */
	public void setisDefault(Integer uid, Integer id) {
		//1.调用持久层的noIsDefault,如果返回值为0,抛出RuntimeException("修改失败")
		int n1=addressMapper.noIsDefault(uid);
		if(n1==0)
			throw new RuntimeException("修改失败");
		int n2=addressMapper.yesIsDefault(id);
		 if(n2==0)
			 throw new RuntimeException("修改失败");
	}
	//返回地址信息
	public Address getAddressById(Integer id) {
		 
		return addressMapper.selectAddressById(id);
	}
	/**
	 * 修改收货人地址
	 */
	public void updateAddressById(Address address) {
		 address.setRecvDistrict(dictMapper.selectProvinceNameByCode(address.getRecvProvince())+""+
				 dictMapper.selectCityNameByCode(address.getRecvCity())+""+
				 dictMapper.selectAreaNameByCode(address.getRecvArea()));
		 addressMapper.updateById(address);
	}
	/**
	 * 根基id 删除收件人地址
	 */
	public void deleteAddressById(Integer id) {
		addressMapper.deleteById(id); 	
	}	
 }
