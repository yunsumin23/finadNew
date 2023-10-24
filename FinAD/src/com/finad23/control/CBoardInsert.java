package com.finad23.control;

import com.finad23.mybatis.CBoardConn;
import com.finad23.mybatis.SqlInsert;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finad23.DTO.CompanyBoardDTO;

public class CBoardInsert implements ConInter {
	static CBoardInsert cboardInsert = new CBoardInsert();
	public static CBoardInsert instance() {
		return cboardInsert;
	}
	
	@Override
	public String FinAD(HttpServletRequest rq, HttpServletResponse rs) throws Exception {
//		int companyBoardNum;
		String title = rq.getParameter("title");
		String companyName = "1234";//rq.getParameter("companyName");
		String companyInfo1 = "a";//rq.getParameter("companyInfo1");
		String companyInfo2 = "b";//rq.getParameter("companyInfo2");
		String companyInfo3 = "c";//rq.getParameter("companyInfo3");
		String recruitmentDate1 = rq.getParameter("recruitmentDate1");
		String recruitmentDate2 = rq.getParameter("recruitmentDate2");
		String promotionDate1 = rq.getParameter("promotionDate1");
		String promotionDate2 = rq.getParameter("promotionDate2");
		String recruitmentNum = rq.getParameter("recruitmentNum");
		String sex = rq.getParameter("sex");
		int avgViewers = Integer.parseInt(rq.getParameter("avgViewers"));
		int subscribers = Integer.parseInt(rq.getParameter("subscribers"));
		String  underachiever = rq.getParameter("underachiever");
		int promotionMoney = Integer.parseInt(rq.getParameter("promotionMoney"));
		String promotionType = rq.getParameter("promotionType");
//		if(promotionType.equalsIgnoreCase("live")) {
//			promotionType = "live";
//		} else if(promotionType.equalsIgnoreCase("review")) {
//			promotionType = "review";
//		} else if(promotionType.equalsIgnoreCase("contents")) {
//			promotionType = "contents";
//		} else if(promotionType.equalsIgnoreCase("model")) {
//			promotionType = "modle";
//		} else if(promotionType.equalsIgnoreCase("banner")) {
//			promotionType = "banner";
//		} else if(promotionType.equalsIgnoreCase("cf")) {
//			promotionType = "cf";
//		} else {
//			promotionType = "another";
//		}
		String previousPromotion1 = "d";//rq.getParameter("previousPromotion1");
		String previousPromotion2 = "e";//rq.getParameter("previousPromotion2");
		String previousPromotion3 = "f";//rq.getParameter("previousPromotion3");
		String text = rq.getParameter("text");
//		String companyWriteDate = rq.getParameter("companyWriteDate");
		
		CompanyBoardDTO companyBoardDTO = new CompanyBoardDTO();
		companyBoardDTO.setTitle(title);
		companyBoardDTO.setCompanyName(companyName);
		companyBoardDTO.setCompanyInfo1(companyInfo1);
		companyBoardDTO.setCompanyInfo2(companyInfo2);
		companyBoardDTO.setCompanyInfo3(companyInfo3);
		companyBoardDTO.setRecruitmentDate1(recruitmentDate1);
		companyBoardDTO.setRecruitmentDate2(recruitmentDate2);
		companyBoardDTO.setPromotionDate1(promotionDate1);
		companyBoardDTO.setPromotionDate2(promotionDate2);
		companyBoardDTO.setRecruitmentNum(recruitmentNum);
		companyBoardDTO.setAvgViewers(avgViewers);
		companyBoardDTO.setSubscribers(subscribers);
		companyBoardDTO.setSex(sex);
		companyBoardDTO.setUnderachiever(underachiever);
		companyBoardDTO.setPromotionMoney(promotionMoney);
		companyBoardDTO.setPromotionType(promotionType);
		companyBoardDTO.setPreviousPromotion1(previousPromotion1);
		companyBoardDTO.setPreviousPromotion2(previousPromotion2);
		companyBoardDTO.setPreviousPromotion3(previousPromotion3);
		companyBoardDTO.setText(text);
//		companyBoardDTO.setCompanyWriteDate(companyWriteDate);
		
		
		SqlInsert insert = SqlInsert.instance();
		insert.sqlInsert(companyBoardDTO);
		
		
		
		
		
		
//		System.out.println("제목 " + companyBoardDTO.getTitle());
//		System.out.println("담당자정보 " + companyBoardDTO.getCompanyInfo1());
//		System.out.println("담당자정보 " + companyBoardDTO.getCompanyInfo2());
//		System.out.println("담당자정보 " + companyBoardDTO.getCompanyInfo3());
//		System.out.println("모집기간 " + companyBoardDTO.getRecruitmentDate1());
//		System.out.println("모집기간 " + companyBoardDTO.getRecruitmentDate2());
//		System.out.println("홍보기간 " + companyBoardDTO.getPromotionDate1());
//		System.out.println("홍보기간 " + companyBoardDTO.getPromotionDate2());
//		System.out.println("모집인원 " + companyBoardDTO.getRecruitmentNum());
//		System.out.println("평균시청자 " + companyBoardDTO.getAvgViewers());
//		System.out.println("구독자 " + companyBoardDTO.getSubscribers());
//		System.out.println("성별 " + companyBoardDTO.getSex());
//		System.out.println("미달자   " + companyBoardDTO.getUnderachiever());
//		System.out.println("광고진행비 " + companyBoardDTO.getPromotionMoney());
//		System.out.println("광고유형 " + companyBoardDTO.getPromotionType());
//		System.out.println("이전광고사례 " + companyBoardDTO.getPreviousPromotion1());
//		System.out.println("이전광고사례 " + companyBoardDTO.getPreviousPromotion2());
//		System.out.println("이전광고사례 " + companyBoardDTO.getPreviousPromotion3());
//		System.out.println("내용 " + companyBoardDTO.getText());
	
		
		
		return null;
}
}
