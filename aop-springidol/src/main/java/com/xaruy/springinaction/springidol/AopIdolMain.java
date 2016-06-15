package com.xaruy.springinaction.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Idol≈≈¡∑
 */
public class AopIdolMain {
	
	public static void main(String[] args) throws Exception{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-springidol.xml");

		Performer performer = (Performer)ctx.getBean("kenny"); 
		performer.perform();

	}
}
