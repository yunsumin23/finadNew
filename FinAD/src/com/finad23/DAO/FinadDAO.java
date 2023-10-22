package com.finad23.DAO;

import java.sql.Connection;

import javax.sql.DataSource;

// DAO페이지 임니다 기본 양식은 만들어 뒀으니 사용하면 됩니다.


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
