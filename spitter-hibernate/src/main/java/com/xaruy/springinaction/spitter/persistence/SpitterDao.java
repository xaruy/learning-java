package com.xaruy.springinaction.spitter.persistence;

import com.xaruy.springinaction.spitter.domain.Spitter;

public interface SpitterDao {
    void addSpitter(Spitter spitter);
	
	void saveSpitter(Spitter spitter);
	
	Spitter getSpitterById(long id);

}
