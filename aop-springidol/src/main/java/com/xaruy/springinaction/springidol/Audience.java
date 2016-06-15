package com.xaruy.springinaction.springidol;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 观众类定义切面通知
 * @author xaruy
 *
 */
@Component
@Aspect  //注解定义切面
public class Audience {
	
	//定义切点
	@Pointcut("execution(* com.xaruy.springinaction.springidol.Performer.perform(..))")
	public void performance(){}
	
	@Before("performance()")
	public void takeSeats() {   //表演之前 找位置
		System.out.println("The audience is taking their seats.");
	}
	
	@Before("performance()")
	public void turnOffCellPhones() {   //表演之前关手机
		System.out.println("The audience is turning off their cellphones");
	}
	
	@AfterReturning("performance()")
	public void applaud() {  //表演成功之后鼓掌
		System.out.println("CLAP CLAP CLAP");
	}
	
	@AfterThrowing("performance()")
	public void demandRefund() {  //表演失败，要求退钱
		System.out.println("Boo! We want our money back!");
	}
	
	@Around("performance()")  //注解环绕通知
	public void watchPerFormance(ProceedingJoinPoint joinpoint) {
		try {
			System.out.println("The audience is start time");
			long start = System.currentTimeMillis();//表演前开始计时
			
			joinpoint.proceed(); //执行被通知方法
			
			long end = System.currentTimeMillis(); //表演成功之后计时
			System.out.println("The performance took " + (end - start) + " milliseconds");
		} catch (Throwable t) {
			System.out.println("Boo! Boo!");
		}
	}

}
