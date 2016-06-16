package com.xaruy.springinaction.spitter;

import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class JdbcSpitterDao extends JdbcDaoSupport implements SpitterDao {
	
	private static final String SQL_INSERT_SPITTER = 
			"insert into spitter (username, password, fullname) value (?, ?, ?)";
	private static final String SQL_UPDATE_SPITTER = 
			"update spitter set username = ?, password = ?, fullname = ? where id = ?";
	private static final String SQL_SELECT_SPITTER = 
			"select id, username, password, fullname from spitter where id = ?";
	
	public void addSpitter(Spitter spitter) {
		getJdbcTemplate().update(SQL_INSERT_SPITTER, 
				spitter.getUsername(),
				spitter.getPassword(),
				spitter.getFullName());
	}

	public void saveSpitter(Spitter spitter) {
		getJdbcTemplate().update(SQL_UPDATE_SPITTER, 
				spitter.getUsername(),
				spitter.getPassword(),
				spitter.getFullName(),
				spitter.getId());
	}

	public Spitter getSpitterById(long id) {
		//ох©уве
		return null;
	}

}
