package Test;

 
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IUserService;

public class TestUser {
	@Test
	public void testUserById() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext
				("spring-dao.xml", "spring-service.xml");
		IUserService iss = ac.getBean("iUserService", IUserService.class);
		User user=iss.getUserById(1);
		System.out.println(""+user);
	}
	@Test
	public void testPerson() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext
				("spring-dao.xml", "spring-service.xml");
		IUserService iss = ac.getBean("iUserService", IUserService.class);
		iss.updateUser(5,"dalaoli",1,"14725836988","dalaoli@wpt.com");
		System.out.println("修改成功!");
		
	}
	@Test//检测业务层密码修改
	public void testtestPassword2() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext
				("spring-dao.xml", "spring-service.xml");
		IUserService iss = ac.getBean("iUserService", IUserService.class);
		iss.changePassword(5,"111222","123456");
		System.out.println("修改成功!");
		
	}
	@Test//通过ID查询
	public void testPassword() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext
				("spring-dao.xml", "spring-service.xml");
		UserMapper um=ac.getBean("userMapper",UserMapper.class);
		 
		System.out.println(""+um.selectById(1));
		
	}
	@Test//修改密码
	public void testUpdate() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext
				("spring-dao.xml", "spring-service.xml");
		UserMapper um=ac.getBean("userMapper",UserMapper.class);
		User user= new User();
		user.setId(5);
		user.setPassword("111222");
		um.update(user);
		System.out.println("修改成功!");
	}
	
	@Test
	public void testLogin2() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext
				("spring-dao.xml", "spring-service.xml");
		IUserService is = ac.getBean("iUserService", IUserService.class);
		User user=is.login("wangpen","wangpeng");
		System.out.println(user);
	}
	/**
	 * 在业务成对用户进行登陆验证
	 */
	@Test
	public void testLogin() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext
				("spring-dao.xml", "spring-service.xml");
		IUserService is = ac.getBean("iUserService", IUserService.class);
		User user=is.login("wangpen","wangpeng");
		System.out.println(user);
	}
	
	@Test
	public void testDemo4() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext
				("spring-dao.xml", "spring-service.xml");
		IUserService is = ac.getBean("iUserService", IUserService.class);
		System.out.println("用户名是否存在:"+is.checkName("李白"));
	}
	
	@Test
	public void testDemo3() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext
				("spring-dao.xml", "spring-service.xml");
		UserMapper um = ac.getBean("userMapper", UserMapper.class);
		System.out.println("用邮箱查询结果:" + um.selectByPhone("123213213"));
		
	}
	//业务层逻辑验证
	@Test
	public void testDemo2() {
		ApplicationContext ac1 = 
				new ClassPathXmlApplicationContext("spring-dao.xml", "spring-service.xml");
		IUserService is = ac1.getBean("iUserService", IUserService.class);
		 System.out.println(is.checkEmail("menghaoran@datang.com"));

	}

	@Test
	public void testInsert() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml", "spring-service.xml");
		UserMapper um = ac.getBean("userMapper", UserMapper.class);
		User user = new User();
		user.setUsername("李靖");
		user.setPassword("166663");
		user.setEmail("lijing@datang.com");
		user.setPhone("15266669999");
		user.setImage("14722433269");
		user.setCreatedUser("zhao");
		user.setModifiedUser("guo");
		System.out.println("开始插入!");
		um.insert(user);
		System.out.println("插入结束!");
	}

	@Test
	public void testSelect() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper um = ac.getBean("userMapper", UserMapper.class);
		User user = um.select("李龟年");
		System.out.println("查询完毕!" + user);
	}

	@Test
	public void testSelect2() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext
				("spring-dao.xml", "spring-service.xml");
		UserMapper um = ac.getBean("userMapper", UserMapper.class);
		//User user= new User();
		System.out.println("用邮箱查询结果:" + um.selectByEmail("menghaoran@datang.com"));
	}

	@Test
	public void testDemo() {
		ApplicationContext ac1 = new ClassPathXmlApplicationContext("spring-dao.xml", "spring-service.xml");
		IUserService is = ac1.getBean("iUserService", IUserService.class);
		User user = new User();
		user.setUsername("李龟年");
		user.setPassword("456123");
		user.setEmail("LiGuiNian@datang.com");
		user.setPhone("15266666666");
		user.setImage("1478888888");
		user.setCreatedUser("zhao");
		user.setModifiedUser("guo");
		is.register(user);

	}
	

}
