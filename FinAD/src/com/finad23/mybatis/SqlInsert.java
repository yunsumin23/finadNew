package com.finad23.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.finad23.DTO.CompanyBoardDTO;

// DB연결하는 파일
public class SqlInsert {
	
	static SqlInsert insert = new SqlInsert();
	public static SqlInsert instance() {
		return insert;
	}
	
	
	SqlSessionFactory sqlsession = SqlControl.getSqlSession();

	public void sqlInsert(CompanyBoardDTO CBoardDTO) {
		
		SqlSession session = sqlsession.openSession(); // open을 했으면 
		
		int i = session.insert("companyWriteID", CBoardDTO); // int타입으로 담아야함
//		이유는 insert 자동 완성 문구에 보면 int가 있어서 일단 int i로 담아 둔거임.
		System.out.println("test3");


		
		
		System.out.println("제목 " + CBoardDTO.getTitle());
		System.out.println("담당자정보 " + CBoardDTO.getCompanyInfo1());
		System.out.println("담당자정보 " + CBoardDTO.getCompanyInfo2());
		System.out.println("담당자정보 " + CBoardDTO.getCompanyInfo3());
		System.out.println("모집기간 " + CBoardDTO.getRecruitmentDate1());
		System.out.println("모집기간 " + CBoardDTO.getRecruitmentDate2());
		System.out.println("홍보기간 " + CBoardDTO.getPromotionDate1());
		System.out.println("홍보기간 " + CBoardDTO.getPromotionDate2());
		System.out.println("모집인원 " + CBoardDTO.getRecruitmentNum());
		System.out.println("평균시청자 " + CBoardDTO.getAvgViewers());
		System.out.println("구독자 " + CBoardDTO.getSubscribers());
		System.out.println("성별 " + CBoardDTO.getSex());
		System.out.println("미달자   " + CBoardDTO.getUnderachiever());
		System.out.println("광고진행비 " + CBoardDTO.getPromotionMoney());
		System.out.println("광고유형 " + CBoardDTO.getPromotionType());
		System.out.println("이전광고사례 " + CBoardDTO.getPreviousPromotion1());
		System.out.println("이전광고사례 " + CBoardDTO.getPreviousPromotion2());
		System.out.println("이전광고사례 " + CBoardDTO.getPreviousPromotion3());
		System.out.println("내용 " + CBoardDTO.getText());
		
		
		
		
		session.commit();
		session.close(); // close를 해야한다.
	}
	
} 
