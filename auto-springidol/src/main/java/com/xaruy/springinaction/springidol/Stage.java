package com.xaruy.springinaction.springidol;

import org.springframework.stereotype.Component;

/**
 * 舞台单例类
 * @author xaruy
 *
 */
@Component("theStage")
public class Stage {
	private Stage() {
	};
	
	//内部静态类 延迟加载实例
	private static class StageSingletonHolder {
		static Stage instance = new Stage();
	}
	
	//返回实例
	public static Stage getInstance() {
		return StageSingletonHolder.instance;
	}

}
