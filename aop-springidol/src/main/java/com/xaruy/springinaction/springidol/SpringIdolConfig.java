package com.xaruy.springinaction.springidol;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 基于Java的配置类
 * @author xaruy
 *
 */
@Configuration
public class SpringIdolConfig {
	
	
	@Bean
	public Performer kenny(){
		Instrumentalist kenny = new Instrumentalist();
		kenny.setSong("Jingle Bells"); 
		kenny.setInstrument(piano());//通过set方法注入bean
		return kenny;
	}
	
	@Bean
	public Instrument piano(){
		return new Piano();
	}

}
