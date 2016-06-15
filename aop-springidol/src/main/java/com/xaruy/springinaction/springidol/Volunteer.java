package com.xaruy.springinaction.springidol;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Volunteer implements Thinker {
	private String thoughts;
 
	@Value("Queen of Hearts")
	public void thinkOfSomething(String thoughts) {
		this.thoughts = thoughts;
	}
	
	public String getThoughts() {
		return thoughts;
	}

}
