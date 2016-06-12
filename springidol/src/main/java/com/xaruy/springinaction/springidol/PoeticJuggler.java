package com.xaruy.springinaction.springidol;

/**
 * 会朗诵诗歌的杂技师
 * @author xaruy
 *
 */
public class PoeticJuggler extends Juggler {
	private Poem poem;
	
	public PoeticJuggler(Poem poem){           //注入Poem
		super();
		this.poem = poem;
	}
	
	public PoeticJuggler(Poem poem, int beanBags){       //注入Poem 和 beanBags
		super(beanBags);
		this.poem = poem;
	}
	
	public void perform() throws PerformanceException{
		super.perform();
		System.out.println("While reciting...");
		poem.recite();
	}

}
