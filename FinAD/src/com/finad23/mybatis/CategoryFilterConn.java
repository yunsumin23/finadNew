package com.finad23.mybatis;

public class CategoryFilterConn {
	static CategoryFilterConn conn = new CategoryFilterConn();
	public static CategoryFilterConn instance() {
		return conn;
	}
	
	
	
}
