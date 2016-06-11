package com.xaruy.springinaction.knights;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightMain {
	
	public static void main(String[] arg){
		//ͨ��ClassPathXmlApplicationContext����Spring ������
		ApplicationContext context =
                new ClassPathXmlApplicationContext("knights.xml");
		//��ȡknight Bean
		Knight knight = (Knight) context.getBean("knight");
		//ʹ�� knight
		knight.embarkOnQuest();
	}

}
