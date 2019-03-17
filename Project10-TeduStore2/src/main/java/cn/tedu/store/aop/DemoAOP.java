package cn.tedu.store.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAOP {
	//1,前置通知:在执行业务逻辑之前执行的切面方法
	@Before("bean(userService)")
	public void test(){
		System.out.println("66666666");
	}
	//2,在执行业务逻辑之后执行的切面方法
	//无论有无异常,都回执行的方法
	@After("bean(userService)")
	public void test2() {
		System.out.println("无论有无异常,都会执行的方法");
	}
	//3,在执行业务逻辑之前执行的切面方法
   //业务逻辑方法不发生异常,才会执行的方法
	@AfterReturning("bean(userService)")
	public void test3() {
		System.out.println("业务逻辑方法不发生异常,才会执行的方法");
	}
	//4,抛出异常
	@AfterThrowing("bean(userService)")
	public void test4() {
		System.out.println("发生异常!");
	}
	
	
	
	
	

}
