package com.xaruy.springinaction.springidol;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 杂技师参赛者
 * @author Administrator
 *
 */
@Component("duke")
public class Juggler implements Performer {
	@Value("15")
	private int beanBags = 3;
	
	public Juggler(){	
	}
	
	/**
	 * 通过构造器能够注入豆袋子数
	 * @param beanBags
	 */
	
	public Juggler(int beanBags){
		this.beanBags = beanBags;
	}
	
	public void perform() throws PerformanceException {
		System.out.println("JUGGLING " + beanBags + " BEANBAGS");
	}

}
