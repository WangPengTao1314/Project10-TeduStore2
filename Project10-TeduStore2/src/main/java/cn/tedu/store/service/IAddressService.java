package cn.tedu.store.service;
 
import java.util.List;

import cn.tedu.store.bean.Address;

public interface IAddressService {
	/**
	 * 根据id 
	 * @param id
	 */
	public void updateAddressById(Address address);
	/**
	 *  通过用户ID 删除收件地址信息
	 * @param id
	 * @return
	 */
	public  void deleteAddressById(Integer id);
	/**
	 * 根据id查询结果
	 * @param id
	 * @return
	 */
	public Address getAddressById(Integer id);
	/**
	 * 保存收获地址
	 * @param address
	 */
	public void saveAddress(Address address);
	/**
	 * 返回地址集合列表
	 * @param uid
	 * @return
	 */
	public List<Address>returnAddressList(Integer uid);
	/**
	 *  设置默认值
	 * @param uid
	 * @param ids
	 */
	public void setisDefault(Integer uid,Integer id);

}
