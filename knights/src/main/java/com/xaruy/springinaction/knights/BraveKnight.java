package com.xaruy.springinaction.knights;

public class BraveKnight implements Knight {
	private Quest quest;
	
	public BraveKnight(Quest quest){
		//Questʵ�������ͨ��������ע��
		this.quest = quest;
	}

	public void embarkOnQuest() throws QuestException {
		quest.embrak();
	}

}
