package com.xaruy.springinaction.springidol;

/**
 * ��̨������
 * @author xaruy
 *
 */
public class Stage {
	private Stage() {
	};
	
	//�ڲ���̬�� �ӳټ���ʵ��
	private static class StageSingletonHolder {
		static Stage instance = new Stage();
	}
	
	//����ʵ��
	public static Stage getInstance() {
		return StageSingletonHolder.instance;
	}

}
