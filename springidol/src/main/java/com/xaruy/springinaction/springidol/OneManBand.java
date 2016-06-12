package com.xaruy.springinaction.springidol;

import java.util.Collection;

/**
 * 一人乐队，演示装配list集合
 * @author xaruy
 *
 */
public class OneManBand implements Performer {
	
	private Collection<Instrument> instruments;
	
	public OneManBand() {
		
	}
	
	
	public void setInstruments(Collection<Instrument> instruments) {   //注入集合
		this.instruments = instruments;
	}

	public void perform() throws PerformanceException {
		for(Instrument instrument : instruments) {
			instrument.play();
		}

	}

}
