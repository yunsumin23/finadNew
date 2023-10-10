package com.finad23.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class CategoryFilterConn {
	static CategoryFilterConn conn = new CategoryFilterConn();
	public static CategoryFilterConn instance() {
		return conn;
	}
	SqlSessionFactory sqlsession = SqlConnect.getSqlSession();
	
	public void filter() {
		
	}
}
