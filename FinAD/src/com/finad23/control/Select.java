package com.finad23.control;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.finad23.DTO.CompanyBoardDTO;
import com.finad23.mybatis.SqlConnect;



public class Select {
	
	static Select select = new Select();
	public static Select instance() {
		return select;
	}
	
	SqlSessionFactory sqlSessionFactory = SqlConnect.getSqlSession();
	
	public List<CompanyBoardDTO> dbSelect() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<CompanyBoardDTO> list = sqlSession.selectList("companyWriteID");
		sqlSession.close();
		return list;
				
	}

}
