package com.xaruy.springinaction.springidol;

/**
 * �Ӽ�ʦ������
 * @author Administrator
 *
 */
public class Juggler implements Performer {
	private int beanBags = 3;
	
	public Juggler(){	
	}
	
	/**
	 * ͨ���������ܹ�ע�붹������
	 * @param beanBags
	 */
	public Juggler(int beanBags){
		this.beanBags = beanBags;
	}
	
	public void perform() throws PerformanceException {
		System.out.println("JUGGLING " + beanBags + " BEANBAGS");
	}

}
