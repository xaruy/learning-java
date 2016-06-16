package com.xaruy.springinaction.spitter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class JdbcSpitterDao implements SpitterDao {
	
	private static final String SQL_INSERT_SPITTER = 
			"insert into spitter (username, password, fullname) value (?, ?, ?)";
	private static final String SQL_UPDATE_SPITTER = 
			"update spitter set username = ?, password = ?, fullname = ? where id = ?";
	private static final String SQL_SELECT_SPITTER = 
			"select id, username, password, fullname from spitter where id = ?";
	
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void addSpitter(Spitter spitter) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = dataSource.getConnection();
			stmt =conn.prepareStatement(SQL_INSERT_SPITTER);
			stmt.setString(1, spitter.getUsername());
			stmt.setString(2, spitter.getPassword());
			stmt.setString(3, spitter.getFullName());
			
			stmt.execute();
			
		} catch (SQLException e) {
			// do something...not sure what,though
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// I'm even less sure about what to do here
			}
		}

	}

	public void saveSpitter(Spitter spitter) {
		Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = dataSource.getConnection();

            stmt = conn.prepareStatement(SQL_UPDATE_SPITTER); 

            stmt.setString(1, spitter.getUsername());
            stmt.setString(2, spitter.getPassword());
            stmt.setString(3, spitter.getFullName());

            stmt.execute();
        } catch (SQLException e) {
        	 // Still not sure what I'm supposed to do here
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // or here
            }
        }

	}

	public Spitter getSpitterById(long id) {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
		try {
			conn = dataSource.getConnection();

            stmt = conn.prepareStatement(SQL_SELECT_SPITTER); 
            
            stmt.setLong(1, id);
            
            rs = stmt.executeQuery();
            
            Spitter spitter = null;
            if (rs.next()) {
            	spitter = new Spitter();
            	spitter.setId(rs.getLong("id"));
            	spitter.setUsername(rs.getString("username"));
            	spitter.setPassword(rs.getString("password"));
            	spitter.setFullName(rs.getString("fullname"));
            }
            return spitter;	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try{
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {}
		}
		return null;
	}

}
