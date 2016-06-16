package com.xaruy.springinaction.spitter;

public interface SpitterDao {
	
	void addSpitter(Spitter spitter);
	
	void saveSpitter(Spitter spitter);
	
	Spitter getSpitterById(long id);

}
