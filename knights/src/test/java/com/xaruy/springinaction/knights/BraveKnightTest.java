package com.xaruy.springinaction.knights;

import static org.mockito.Mockito.*;

import org.junit.Test;

public class BraveKnightTest {
	@Test
	public void knightShoulEmbarkOnQuest() throws QuestException{
		//mock实现Quest
		Quest mockQuest = mock(Quest.class);
		//注入mock的Quest
		BraveKnight knight = new BraveKnight(mockQuest);
		knight.embarkOnQuest();
		
		verify(mockQuest, times(1)).embrak();
	}

}
