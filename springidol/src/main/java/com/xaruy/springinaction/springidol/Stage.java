package com.xaruy.springinaction.springidol;

/**
 * 舞台单例类
 * @author xaruy
 *
 */
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
