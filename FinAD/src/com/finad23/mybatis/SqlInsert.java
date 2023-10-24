package com.finad23.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.finad23.DTO.CompanyBoardDTO;

// DB연결하는 파일
public class SqlInsert {
	
	static SqlInsert ins = new SqlInsert();
	public static SqlInsert instance() {
		return ins;
	}
	
	
	SqlSessionFactory sqlsession = SqlControl.getSqlSession();

	public void sqlInsert(CompanyBoardDTO CBoard) {
		
		SqlSession session = sqlsession.openSession(); // open을 했으면 
		
//		System.out.println(user.getInfluUserId()); // 혹시 시스템에 찍히는지 찍어봄
		
		int i = session.insert("companyWriteID", CBoard); // int타입으로 담아야함
//		이유는 insert 자동 완성 문구에 보면 int가 있어서 일단 int i로 담아 둔거임.
		session.commit();
		session.close(); // close를 해야한다.
	}
	
} 
