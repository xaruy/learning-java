package com.xaruy.spitter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xaruy.spitter.dao.Spitter;
import com.xaruy.spitter.dao.SpitterDao;
import com.xaruy.spitter.dao.Spittle;

import static java.lang.Math.min;
import static java.util.Collections.reverse;


@Component("spitterService")
@Transactional(propagation = Propagation.REQUIRED)
public class SpitterServiceImpl implements SpitterService {
	
	@Autowired
    SpitterDao spitterDao;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Spittle> getRecentSpittles(int count) {
		List<Spittle> recentSpittles = spitterDao.getRecentSpittle();
		reverse(recentSpittles);

        return recentSpittles.subList(0,
                min(2, recentSpittles.size()));
	}

	public Spitter getSpitter(String username) {
		return spitterDao.getSpitterByUsername(username);
	}
	
	public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
        return spitterDao.getSpittlesForSpitter(spitter);
    }

	public List<Spittle> getSpittlesForSpitter(String username) {
		Spitter spitter = spitterDao.getSpitterByUsername(username);
        return getSpittlesForSpitter(spitter);
	}

	public void saveSpitter(Spitter spitter) {
		if (spitter.getId() == null) {
            spitterDao.addSpitter(spitter);
        } else {
            spitterDao.saveSpitter(spitter);
        }

	}

}
