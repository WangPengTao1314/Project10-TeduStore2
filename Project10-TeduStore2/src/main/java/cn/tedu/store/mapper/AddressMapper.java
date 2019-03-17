package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Address;

public interface AddressMapper {
	/**
	 * 通过id查询收货人地址
	 * @param id
	 * @return
	 */
	public Address selectAddressById(Integer id);
	/**
	 * 添加数据
	 * @param address
	 */
	public void insert(Address address);
	/**
	 * 通过uid收或城市列表
	 * @param uid
	 * @return
	 */
	public List<Address>selectAddressByUid(Integer uid);
	/**
	 * 修改指定的id的值为isDefault=1
	 * @param isDefault
	 * @return
	 */
	public Integer yesIsDefault(Integer id);
	/**
	 * 修改指定uid的值的isDefault=0
	 * @param uid
	 * @return
	 */
	public Integer noIsDefault(Integer uid);
	/**
	 *  根据用户id修改用户信息
	 * @param id
	 */
	public void updateById(Address address);
	/**
	 * 根据ID 删除用户信息
	 * @param id
	 */
	public void  deleteById(Integer id);
}
