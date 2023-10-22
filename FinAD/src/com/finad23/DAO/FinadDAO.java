package com.finad23.DAO;

import java.sql.Connection;

import javax.sql.DataSource;

public class FinadDAO {
	DataSource ds;
	Connection con;
	private static FinadDAO finadDAO;
	
	private FinadDAO() {
	}
	
	public static FinadDAO getInstance() {
		if(finadDAO == null) {
			finadDAO = new FinadDAO();
		}
		return finadDAO;
	}
	
	public void setConnection(Connection conn) {
		this.con = con;
	}
	
	
}
