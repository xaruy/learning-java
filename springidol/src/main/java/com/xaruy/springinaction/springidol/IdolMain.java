package com.xaruy.springinaction.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Idol排练
 */
public class IdolMain {
	
	public static void main(String[] args) throws Exception{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-idol.xml");
		Performer performer = (Performer)ctx.getBean("hank2"); //可以表演的bean有： duke,poeticDuke,kenny,hank,hank2
		performer.perform();

	}
}
