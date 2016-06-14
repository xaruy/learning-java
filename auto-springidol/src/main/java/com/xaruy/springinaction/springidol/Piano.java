package com.xaruy.springinaction.springidol;

import org.springframework.stereotype.Component;

@Component
public class Piano implements Instrument {
	
	public Piano() {
	}

	public void play() {
		System.out.println("PLINK PLINK PLINK");

	}

}
