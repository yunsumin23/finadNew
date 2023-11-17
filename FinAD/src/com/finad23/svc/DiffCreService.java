package com.finad23.svc;

import java.sql.Connection;

import com.finad23.DAO.FinadDAO;

import static com.finad23.db.JdbcUtil.*;
public class DiffCreService {
	public void abcd() throws Exception {
		
		Connection conn = getConnection();
		FinadDAO finadDAO = FinadDAO.getInstance();
		finadDAO.setConnection(conn);
		
		
		close(conn);
		
	}
}
