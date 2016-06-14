package com.xaruy.springinaction.springidol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 会朗诵诗歌的杂技师
 * @author xaruy
 *
 */
@Component("poeticDuke")
public class PoeticJuggler extends Juggler {
	@Autowired
	@Qualifier("sonnet29")
	private Poem poem;
	
	
	public PoeticJuggler(Poem poem){           //注入Poem
		super();
		this.poem = poem;
	}
	
	
	public void perform() throws PerformanceException{
		super.perform();
		System.out.println("While reciting...");
		poem.recite();
	}

}
