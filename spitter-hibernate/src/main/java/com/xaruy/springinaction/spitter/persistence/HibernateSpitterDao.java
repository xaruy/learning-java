package com.xaruy.springinaction.spitter.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xaruy.springinaction.spitter.domain.Spitter;

@Repository("spitterDao")
public class HibernateSpitterDao implements SpitterDao {
	private SessionFactory sessionFactory;
	
	@Autowired
    public HibernateSpitterDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	private Session currentSession() {
        return sessionFactory.openSession();  //从sessionFactory获取当前session
    }

	public void addSpitter(Spitter spitter) {
		currentSession().save(spitter);

	}

	public void saveSpitter(Spitter spitter) {
		currentSession().update(spitter);

	}

	public Spitter getSpitterById(long id) {
		return (Spitter) currentSession().get(Spitter.class, id);
	}

}
