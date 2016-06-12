package com.xaruy.springinaction.springidol;

import java.util.Map;

/**
 * һ���ֶӣ���ʾװ��map����
 * @author xaruy
 *
 */
public class OneManBand2 implements Performer {
	
	private Map<String, Instrument> instruments;
	
	public OneManBand2() {
	}
	
	public void setInstruments(Map<String, Instrument> instruments) {  //ע��Map����
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
