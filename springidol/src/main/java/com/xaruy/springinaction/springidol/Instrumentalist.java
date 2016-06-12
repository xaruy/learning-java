package com.xaruy.springinaction.springidol;

/**
 * ���������
 * @author xaruy
 *
 */
public class Instrumentalist implements Performer {

	private String song;
	private Instrument instrument;
	
	
	public String getSong() {
		return song;
	}
	//����ע��song
	public void setSong(String song) {
		this.song = song;
	}
	public String screamSong() {
		return song;
	}
	public Instrument getInstrument() {
		return instrument;
	}
	//����ע������
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
