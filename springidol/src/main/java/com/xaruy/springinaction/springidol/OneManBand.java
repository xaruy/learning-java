package com.xaruy.springinaction.springidol;

import java.util.Collection;

/**
 * һ���ֶӣ���ʾװ��list����
 * @author xaruy
 *
 */
public class OneManBand implements Performer {
	
	private Collection<Instrument> instruments;
	
	public OneManBand() {
		
	}
	
	
	public void setInstruments(Collection<Instrument> instruments) {   //ע�뼯��
		this.instruments = instruments;
	}

	public void perform() throws PerformanceException {
		for(Instrument instrument : instruments) {
			instrument.play();
		}

	}

}
