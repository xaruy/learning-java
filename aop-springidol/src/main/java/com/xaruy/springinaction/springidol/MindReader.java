package com.xaruy.springinaction.springidol;

/**
 * 读心者接口
 * @author xaruy
 *
 */
public interface MindReader {
	
	void interceptThoughts(String thoughts);
	
	String getThoughts();

}
