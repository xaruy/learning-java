package com.xaruy.springinaction.spitter.persistence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xaruy.springinaction.spitter.domain.Spitter;

public class hibMain {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spitter-hibernate.xml");
        SpitterDao dao = (SpitterDao)context.getBean("spitterDao");

        Spitter s = new Spitter();
        s.setFullName("xaruy test");
        s.setUsername("aruy test");
        s.setEmail("twegw@few.com");
        s.setPassword("123456");

        dao.addSpitter(s);
        Spitter sp = dao.getSpitterById(2);
        System.out.println(sp.getUsername());
    }

}
