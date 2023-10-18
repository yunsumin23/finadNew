package com.finad23.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.finad23.DTO.CategoryFilterDTO;

public class CategoryFilterConn { // DB연결하는 파일
	static CategoryFilterConn conn = new CategoryFilterConn();
	public static CategoryFilterConn instance() {
		return conn;
	}
	SqlSessionFactory sqlsession = SqlConnect.getSqlSession();
	
	
	public List<CategoryFilterDTO> filter(CategoryFilterDTO filter) {
		SqlSession session = sqlsession.openSession();

		
		
		List<CategoryFilterDTO> list = session.selectList("filterId", filter);
		System.out.println(filter);
		System.out.println("Conn페이지 "+ filter.getShorts());
		System.out.println("Conn페이지 "+ filter.getSub());
		System.out.println("Conn페이지 "+ filter.getPrice());
		System.out.println("Conn페이지 "+ filter.getAvg());
		session.close(); // session을 열였으니 닫아준다.
		return list;
	}
	
}