package com.xaruy.springinaction.springidol;

/**
 * ������ʫ����Ӽ�ʦ
 * @author xaruy
 *
 */
public class PoeticJuggler extends Juggler {
	private Poem poem;
	
	public PoeticJuggler(Poem poem){           //ע��Poem
		super();
		this.poem = poem;
	}
	
	public PoeticJuggler(Poem poem, int beanBags){       //ע��Poem �� beanBags
		super(beanBags);
		this.poem = poem;
	}
	
	public void perform() throws PerformanceException{
		super.perform();
		System.out.println("While reciting...");
		poem.recite();
	}

}
