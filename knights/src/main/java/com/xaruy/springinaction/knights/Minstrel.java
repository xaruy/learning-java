package com.xaruy.springinaction.knights;

/**
 *吟游诗人AOP
 */
public class Minstrel {
	
	//探险之前调用
	public void singBeforeQuest(){
		System.out.println("Fa la la; The knight is so brave!");
	}
	
	//探险之后调用
	public void singAfterQuest(){
		System.out.println("Tee hee he; The brave knight did embark on a quest!");
	}

}
