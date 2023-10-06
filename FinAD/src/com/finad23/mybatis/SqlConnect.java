package com.finad23.mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlConnect {
	
	private static SqlSessionFactory sqlSessionFactory; 
	
	public static SqlSessionFactory getSqlSession() {
		return sqlSessionFactory;
	}
	
	static {
		try {
			String resource = "com/finad23/mybatis/database.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactoryBuilder SqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			sqlSessionFactory = SqlSessionFactoryBuilder.build(reader);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
