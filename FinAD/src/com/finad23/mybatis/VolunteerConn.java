package com.finad23.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.finad23.DTO.CBoardVolunteerDTO;


public class VolunteerConn {

	static VolunteerConn select = new VolunteerConn();
	public static VolunteerConn instance() {
		return select;
	}

	SqlSessionFactory sqlSessionFactory = SqlConnect.getSqlSession();

	public List<CBoardVolunteerDTO> dbSelect() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<CBoardVolunteerDTO> list = sqlSession.selectList("cBoardVolID");
		sqlSession.close();
		return list;

	}

}