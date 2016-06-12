package com.xaruy.springinaction.springidol;

/**
 * ÒôÀÖÑİ×à¼Ò
 * @author xaruy
 *
 */
public class Instrumentalist implements Performer {

	private String song;
	private Instrument instrument;
	
	
	public String getSong() {
		return song;
	}
	//ÊôĞÔ×¢Èësong
	public void setSong(String song) {
		this.song = song;
	}
	public String screamSong() {
		return song;
	}
	public Instrument getInstrument() {
		return instrument;
	}
	//ÊôĞÔ×¢ÈëÀÖÆ÷
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	
	
	public Instrumentalist() {
	}
	public void perform() throws PerformanceException {
		System.out.println("Playing " + song + " : ");
        instrument.play();
	}

}
