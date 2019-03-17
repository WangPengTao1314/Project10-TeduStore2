package cn.tedu.store.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.ClassNameAlreadyException;

@Controller
public class UserController extends BaseController {
	@Resource(name = "iUserService")
	private IUserService iUserService;

	@RequestMapping("/showRegister.do")
	public String showRegister() {
	 
		return "register";
	}

	/* ~~~~~~~~~~~~~~~~~~~~~~用户注册~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	/**
	 * 定义处理用户注册失去焦点的方法
	 * 
	 * @return
	 */
	@RequestMapping("/checkName.do")
	@ResponseBody
	public ResponseResult<Void> checkName(String username) {
		ResponseResult<Void> rr = null;
		if (iUserService.checkName(username)) {
			rr = new ResponseResult<Void>();
			rr.setState("0");
			rr.setMessage("用户名已存在");
		} else {
			rr = new ResponseResult<Void>();
			rr.setState("1");
			rr.setMessage("用户名正确!");
		}
		return rr;
	}

	/**
	 * 验证注册邮箱
	 * 
	 * @return
	 */
	@RequestMapping("/checkEmail.do")
	@ResponseBody
	public ResponseResult<Void> checkEmail(String email) {
		ResponseResult<Void> rr = null;
		if (iUserService.checkEmail(email)) {
			rr = new ResponseResult<Void>();
			rr.setState("0");
			rr.setMessage("邮箱已存在!!");
		} else {
			rr = new ResponseResult<Void>();
			rr.setState("1");
			rr.setMessage("注册,邮箱正确!!!!!");
		}
		return rr;
	}

	@RequestMapping("/checkPhone.do")
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone) {
		ResponseResult<Void> rr = null;
		if (iUserService.checkPhone("132131")) {
			rr = new ResponseResult<Void>();
			// 状态码为0时表示电话号码已存在,注册失败
			rr.setState("0");
			rr.setMessage("电话号码已存在!");
		} else {
			rr = new ResponseResult<Void>();
			// 状态码为1时表示电话号码不存在在注册成功
			rr.setState("1");
			rr.setMessage("恭喜你,通过了!");
		}
		return rr;

	}

	/**
	 * 用于验证当用户名已存在时,的反复操作
	 * 
	 * @param username
	 * @param password
	 * @param email
	 * @param phone
	 * @return
	 */
	@RequestMapping("/register.do")
	@ResponseBody
	public ResponseResult<Void> register(@RequestParam("uname") String username, @RequestParam("upwd") String password,
			String email, String phone) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhone(phone);
		try {
			iUserService.register(user);
		} catch (ClassNameAlreadyException e) {
			rr.setState("0");
			rr.setMessage("用户名已存在!");
		}
		return rr;
	}

	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~用户登录~~~~~~~~~~~~~~~~~~~~~~~~ */
	/**
	 * 显示登陆页面
	 * 
	 * @return view组件名
	 */
	@RequestMapping("/toLogin.do")
	public String toLogin() {
		 
		return "login";
	}

	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login
		(@RequestParam("lname") String username, 
				@RequestParam("lwd") String password,HttpSession session) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		// 调用业务层login()方法
		try {
			User user=iUserService.login(username, password);
			session.setAttribute("user",        
		            user);
			rr.setState("1");
			rr.setMessage("登陆成功!");
		} catch (Exception e) {
			//登陆失败时的处理
			rr.setState("0");
			rr.setMessage(e.getMessage());
		}
		return rr;
	}
	/*~~~~~~~~~~在index.jsp页面中完成用户退出功能~~~~~~~~~~~~~~*/
	@RequestMapping("/exit.do")
	public String exit(HttpSession session) {
		//让session无效实现退出功能
		session.invalidate();
		return "redirect:showIndex.do";
	}
	//在personal_password.jsp页面中实现用户退出功能
	@RequestMapping("/personal_exit.do")
	public String personal_exit() {
		//实现返回到上个页面的功能
		return "redirect:showIndex.do";
	}
	
	/*~~~~~~~~~~~修改密码~~~~~~~~~~~~*/
	@RequestMapping("/showPassword.do")
	public String showPassword() {
	 
		return "personal_password";
	}
	/**
	 * 修改密码的异步操作
	 */
	@RequestMapping("/changePassword.do")
	@ResponseBody//响应方式
	public ResponseResult<Void> changePassword 
			(HttpSession session,String oldPwd,String newPwd){
		ResponseResult<Void>rr=new ResponseResult<Void>();
		try {
			iUserService.changePassword(getID(session), oldPwd, newPwd);
			rr.setState("1");
			rr.setMessage("密码修改成功!");
		}catch(Exception e) {
			rr.setState("0");
			rr.setMessage(e.getMessage());
		}
		return rr;
	}
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	@RequestMapping("/showPersonInfo.do")
	public String showPersonInfo() {
		System.out.println("showPwesonInfo.do页面的显示!");
		return "personInfo";
	}
	/*~~~~~~~~~修改个人用户信息~~~~~~~~~~~~~~*/
	@RequestMapping("/changePersonInfor.do")
	@ResponseBody
	public ResponseResult<Void> changePersonInfor
		(HttpSession session,String username,Integer gender,String phone,String email){
		ResponseResult<Void>rr=new ResponseResult<Void>();
		 try {
			 iUserService.updateUser(getID(session), username, gender, phone, email);
			//设置修改后的user对象
			 User user=iUserService.getUserById(getID(session));
			 session.setAttribute("user",user);
			 rr.setState("1");
			 rr.setMessage("修改成功");
		 }catch(Exception e) {
			 rr.setState("0");
			 rr.setMessage(e.getMessage());
		 }
		return rr;
	}
	/*~~~~~~~~~~~~~我的收藏~~~~~~~~~~~~~*/
	@RequestMapping("changeFavorites.do")
	public String favorites() {
		
		return "favorites";
	}
	
	/*~~~~~~~~~~~~~~~上传头像~~~~~~~~~~~~~~~~~~*/
	@RequestMapping("/upload.do")
	@ResponseBody
	public ResponseResult<Void>upLoad(
  @RequestParam("file") MultipartFile file,
  HttpSession session){
		ResponseResult<Void> rr=new ResponseResult<Void>();
		try {
			//获取服务器的真事路径
			String path=
					session.getServletContext().getRealPath("/");
			System.out.println(path);
			//上传图片
			file.transferTo(new File(path,"/upload/"+file.getOriginalFilename()));
			//
		  iUserService.getImageById("/upload/"+file.getOriginalFilename(),this.getID(session));
			//
		  User u=iUserService.getUserById(this.getID(session));
		  	session.setAttribute("user",u);
		  rr.setState("1");
			rr.setMessage("上传成功!");
		}catch(Exception e) {
			rr.setState("0");
			rr.setMessage("上传失败");
		}
		return rr;
	}
	
	
}
