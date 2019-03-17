package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IAddressService;

@Controller//控制反转
public class AddressController extends BaseController{
	@Resource
	private IAddressService iAddressService;
	
	/*~~~~~~~~~~~~~地址管理~~~~~~~~~~~~~*/
	//显示页面
	@RequestMapping("/showAddress.do")
	public String showAddress() {
		System.out.println("地址栏管理页面显示!~");
		return "addressAdmin";
	}
	@RequestMapping("/getAddress.do")
	@ResponseBody
	public ResponseResult<List<Address>>  getAddressByUid(HttpSession session){
		ResponseResult<List<Address>> rr=new ResponseResult<List<Address>>();
		rr.setDatap(iAddressService.returnAddressList(getID(session)));
		return rr;
	}
	
	@RequestMapping("/addAddress.do")
	@ResponseBody
	public ResponseResult<Void> addAddress(
			HttpSession session,
			@RequestParam("receiverName") String recvName,
			@RequestParam("receiverState") String recvProvince,
			@RequestParam("receiverCity") String recvCity,
			@RequestParam("receiverDistrict") String recvArea,
			@RequestParam("receiverAddress") String recvAddress,
			@RequestParam("receiverMobile") String recvPhone,
			@RequestParam("receiverPhone") String recvTel,
			@RequestParam("receiverZip") String recvZip,
			@RequestParam("addressName") String recvTag){
		ResponseResult<Void> rr=new ResponseResult<Void>();
		System.out.println(recvName);
		System.out.println(recvProvince);
		System.out.println(recvCity);
		System.out.println(recvArea);
		System.out.println(recvAddress);
		System.out.println(recvPhone);
		System.out.println(recvTel);
		System.out.println(recvZip);
		System.out.println(recvTag);
		Address address =new Address();
		address.setUid(getID(session));
		address.setRecvName(recvName);
		address.setRecvProvince(recvProvince);
		address.setRecvCity(recvCity);
		address.setRecvArea(recvArea);
		address.setRecvAddress(recvAddress);
		address.setRecvPhone(recvPhone);
		address.setRecvTel(recvTel);
		address.setRecvZip(recvZip);
		address.setRecvTag(recvTag);
		iAddressService.saveAddress(address); 
		rr.setState("1");
		rr.setMessage("添加成功");
		return rr;
	}
	@RequestMapping("/getDefault.do")
	@ResponseBody
	public ResponseResult<Void>getDefault(HttpSession session,Integer id){
		ResponseResult<Void>rr=new ResponseResult<Void>();
		try {
			iAddressService.setisDefault(getID(session), id);
			rr.setState("1");
			rr.setMessage("获取成功");
		}catch(Exception e) {
			rr.setState("0");
			rr.setMessage(e.getMessage());
		}
		return rr;
	}
	@RequestMapping("/getAddressById.do")
	@ResponseBody
	public ResponseResult<Address>getAddressById(Integer id){
		ResponseResult<Address>rr=new ResponseResult<Address>();
		rr.setDatap(iAddressService.getAddressById(id));
		return rr;
	}
	@RequestMapping("/updateAddressById.do")
	@ResponseBody
	public ResponseResult<Address> updateAddressById(
			Integer id,
			@RequestParam("receiverName") String recvName,
			@RequestParam("receiverState") String recvProvince,
			@RequestParam("receiverCity") String recvCity,
			@RequestParam("receiverDistrict") String recvArea,
			@RequestParam("receiverAddress") String recvAddress,
			@RequestParam("receiverMobile") String recvPhone,
			@RequestParam("receiverPhone") String recvTel,
			@RequestParam("receiverZip") String recvZip,
			@RequestParam("addressName") String recvTag){
		ResponseResult<Address> rr=new ResponseResult<Address> ();
		Address address =new Address();
		address.setId(id);//根据ID修改
		address.setRecvName(recvName);
		address.setRecvProvince(recvProvince);
		address.setRecvCity(recvCity);
		address.setRecvArea(recvArea);
		address.setRecvAddress(recvAddress);
		address.setRecvPhone(recvPhone);
		address.setRecvTel(recvTel);
		address.setRecvZip(recvZip);
		address.setRecvTag(recvTag);
		iAddressService.updateAddressById(address);
		rr.setState("1");
		rr.setMessage("修改成功");
		return rr;
	}
	@RequestMapping("/deleteAddressById.do")
	@ResponseBody
	public ResponseResult<Void>deleteAddressById(Integer id){
		ResponseResult<Void>rr=new ResponseResult<Void>();
		iAddressService.deleteAddressById(id);
		rr.setState("1");
		rr.setMessage("删除成功!");
		return rr;
	}
	

}
