package com.xaruy.springinaction.knights;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightMain {
	
	public static void main(String[] arg){
		//通过ClassPathXmlApplicationContext加载Spring 上下文
		ApplicationContext context =
                new ClassPathXmlApplicationContext("knights.xml");
		//获取knight Bean
		Knight knight = (Knight) context.getBean("knight");
		//使用 knight
		knight.embarkOnQuest();
	}

}
