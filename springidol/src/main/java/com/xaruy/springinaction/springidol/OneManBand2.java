package com.xaruy.springinaction.springidol;

import java.util.Map;

/**
 * 一人乐队，演示装配map集合
 * @author xaruy
 *
 */
public class OneManBand2 implements Performer {
	
	private Map<String, Instrument> instruments;
	
	public OneManBand2() {
	}
	
	public void setInstruments(Map<String, Instrument> instruments) {  //注入Map集合
		this.instruments = instruments;
	}

	public void perform() throws PerformanceException {
		for(String key : instruments.keySet()){
			System.out.print(key + " : ");
			Instrument instrument = instruments.get(key);
			instrument.play();
		}

	}

}
