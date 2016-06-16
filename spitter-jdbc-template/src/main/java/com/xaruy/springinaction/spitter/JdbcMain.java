package com.xaruy.springinaction.spitter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcMain {
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("spitter-jdbc-template.xml");
		JdbcSpitterDao dao = (JdbcSpitterDao)context.getBean("jdbcSpitterDao");
		
		Spitter s = new Spitter();
		s.setUsername("aruy");
		s.setPassword("123456");
		s.setFullName("xaruy");
		
		dao.addSpitter(s);
		
	}

}
