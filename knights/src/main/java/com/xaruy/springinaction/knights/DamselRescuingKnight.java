package com.xaruy.springinaction.knights;

public class DamselRescuingKnight implements Knight{
	private RescueDamselQuest quest;
	
	public DamselRescuingKnight(){
		//ÓëRescueDamselQuest½ôñîºÏ
		quest = new RescueDamselQuest();
	}
	
	public void embarkOnQuest() throws QuestException{
		quest.embrak();
	} 

}
