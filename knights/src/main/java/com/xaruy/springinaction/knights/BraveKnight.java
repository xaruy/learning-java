package com.xaruy.springinaction.knights;

public class BraveKnight implements Knight {
	private Quest quest;
	
	public BraveKnight(Quest quest){
		//Quest实现类可以通过构造器注入
		this.quest = quest;
	}

	public void embarkOnQuest() throws QuestException {
		quest.embrak();
	}

}
