package com.xaruy.springinaction.springidol;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ����Java��������
 * @author xaruy
 *
 */
@Configuration
public class SpringIdolConfig {
	
	
	@Bean
	public Performer kenny(){
		Instrumentalist kenny = new Instrumentalist();
		kenny.setSong("Jingle Bells"); 
		kenny.setInstrument(piano());//ͨ��set����ע��bean
		return kenny;
	}
	
	@Bean
	public Instrument piano(){
		return new Piano();
	}

}
