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
		
		int i = session.insert("companyWriteID", CBoard); // int타입으로 담아야함
//		이유는 insert 자동 완성 문구에 보면 int가 있어서 일단 int i로 담아 둔거임.

		
		
//		System.out.println("제목 " + CBoard.getTitle());
//		System.out.println("담당자정보 " + CBoard.getCompanyInfo1());
//		System.out.println("담당자정보 " + CBoard.getCompanyInfo2());
//		System.out.println("담당자정보 " + CBoard.getCompanyInfo3());
//		System.out.println("모집기간 " + CBoard.getRecruitmentDate1());
//		System.out.println("모집기간 " + CBoard.getRecruitmentDate2());
//		System.out.println("홍보기간 " + CBoard.getPromotionDate1());
//		System.out.println("홍보기간 " + CBoard.getPromotionDate2());
//		System.out.println("모집인원 " + CBoard.getRecruitmentNum());
//		System.out.println("평균시청자 " + CBoard.getAvgViewers());
//		System.out.println("구독자 " + CBoard.getSubscribers());
//		System.out.println("성별 " + CBoard.getSex());
//		System.out.println("미달자   " + CBoard.getUnderachiever());
//		System.out.println("광고진행비 " + CBoard.getPromotionMoney());
//		System.out.println("광고유형 " + CBoard.getPromotionType());
//		System.out.println("이전광고사례 " + CBoard.getPreviousPromotion1());
//		System.out.println("이전광고사례 " + CBoard.getPreviousPromotion2());
//		System.out.println("이전광고사례 " + CBoard.getPreviousPromotion3());
//		System.out.println("내용 " + CBoard.getText());
		
		
		
		
		session.commit();
		session.close(); // close를 해야한다.
	}
	
} 
