package Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.mapper.UserMapper;
 

public class testMD5 {

	@Test
	public void test() throws Exception, IOException {
		//消息摘要技术()
		String str1=DigestUtils.md5Hex("123455");
		String str2=DigestUtils.md5Hex("12$#%^&");
		//System.out.println(str1);
		//System.out.println(str2);
		//System.out.println(str1==str2);
		String str3=DigestUtils.md5Hex(new FileInputStream("pom.xml"));
		String str4=DigestUtils.md5Hex(new FileInputStream("pom2.xml"));
		System.out.println(str3);
		System.out.println(str4);
		System.out.println(str3.equals(str4));
		System.out.println(str3==str4);
		
		//消息摘要加盐加密
		String pwd="123456";
		String salt="你好啊!";
		String strpwd=DigestUtils.md5Hex(pwd+salt);
		System.out.println(strpwd);
	 
	}
	@Test
	public void test2() {
		ApplicationContext ac=
				new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper us=ac.getBean("userMapper",UserMapper.class);
		
		us.updateImageById("/home/soft01/sss.png",1);
		System.out.println("修改成功!");
	}
	
	
	
}
