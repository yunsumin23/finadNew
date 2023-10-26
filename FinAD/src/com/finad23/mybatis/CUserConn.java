package com.finad23.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.finad23.DTO.CompanyUserDTO;


public class CUserConn {
	
	static CUserConn select = new CUserConn();
	public static CUserConn instance() {
		return select;
	}
	
	SqlSessionFactory sqlSessionFactory = SqlConnect.getSqlSession();
	
	public List<CompanyUserDTO> dbSelect() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<CompanyUserDTO> list = sqlSession.selectList("companyUserID");
		sqlSession.close();
		return list;
				
	}

}
