package com.xaruy.spitter.service;

import java.util.List;

import com.xaruy.spitter.dao.Spittle;
import com.xaruy.spitter.dao.Spitter;

public interface SpitterService {
	
	List<Spittle> getRecentSpittles(int count);

	Spitter getSpitter(String username);

	List<Spittle> getSpittlesForSpitter(String username);
	
	List<Spittle> getSpittlesForSpitter(Spitter spitter);

	void saveSpitter(Spitter spitter);

}
