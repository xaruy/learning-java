package com.xaruy.springinaction.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Idol����
 */
public class IdolMain {
	
	public static void main(String[] args) throws Exception{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("auto-springidol.xml");

		Performer performer = (Performer)ctx.getBean("kenny"); //���Ա��ݵ�bean�У� duke,poeticDuke,kenny,
		performer.perform();

	}
}
