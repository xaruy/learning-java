package com.xaruy.spitter.dao;

import java.util.List;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("spitterDao")
public class HibernateSpitterDao implements SpitterDao {
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	
    public HibernateSpitterDao() {
        
    }
	
	private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

	public void addSpitter(Spitter spitter) {
		 currentSession().save(spitter);

	}

	public void saveSpitter(Spitter spitter) {
		// TODO Auto-generated method stub

	}

	public Spitter getSpitterById(long id) {
		return (Spitter) currentSession().get(Spitter.class, id);
	}

	public List<Spittle> getRecentSpittle() {
		List<Spittle> list =  currentSession().createCriteria(Spittle.class).list();
        return list;
	}

	public void saveSpittle(Spittle spittle) {
		currentSession().save(spittle);

	}

	public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
		Query query = currentSession().createQuery("from Spittle where spitter_id=:id");
        query.setParameter("id", spitter.getId());
        List<Spittle> list = query.list();
        return list;
	}

	public Spitter getSpitterByUsername(String username) {
		Query query = currentSession().createQuery("from Spitter where username=:name");
        query.setParameter("name", username);
        List<Spitter> list = query.list();
    
        return list.size() == 0 ? null : list.get(0);
	}

	public void deleteSpittle(long id) {
		 currentSession().delete(getSpittleById(id));

	}

	public Spittle getSpittleById(long id) {
		return (Spittle) currentSession().get(Spittle.class, id);
	}

	public List<Spitter> findAllSpitters() {
		// TODO Auto-generated method stub
		return null;
	}

}
