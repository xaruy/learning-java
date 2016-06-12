package com.xaruy.springinaction.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Idol����
 */
public class IdolMain {
	
	public static void main(String[] args) throws Exception{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-idol.xml");
		Performer performer = (Performer)ctx.getBean("hank2"); //���Ա��ݵ�bean�У� duke,poeticDuke,kenny,hank,hank2
		performer.perform();

	}
}
