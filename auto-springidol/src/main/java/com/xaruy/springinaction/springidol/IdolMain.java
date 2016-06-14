package com.xaruy.springinaction.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Idol排练
 */
public class IdolMain {
	
	public static void main(String[] args) throws Exception{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("auto-springidol.xml");

		Performer performer = (Performer)ctx.getBean("kenny"); //可以表演的bean有： duke,poeticDuke,kenny,
		performer.perform();

	}
}
