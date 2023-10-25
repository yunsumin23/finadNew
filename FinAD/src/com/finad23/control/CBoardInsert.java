package com.finad23.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finad23.DTO.CompanyBoardDTO;
import com.finad23.mybatis.SqlInsert;

public class CBoardInsert implements ConInter {
	static CBoardInsert cboardInsert = new CBoardInsert();
	public static CBoardInsert instance() {
		return cboardInsert;
	}
	
	@Override
	public String FinAD(HttpServletRequest rq, HttpServletResponse rs) throws Exception {
		System.out.println("test1");
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
		String previousPromotion1 = "d";//rq.getParameter("previousPromotion1");
		String previousPromotion2 = "e";//rq.getParameter("previousPromotion2");
		String previousPromotion3 = "f";//rq.getParameter("previousPromotion3");
		String text = rq.getParameter("text");
		
		CompanyBoardDTO CBoardDTO = new CompanyBoardDTO();
		CBoardDTO.setTitle(title);
		CBoardDTO.setCompanyName(companyName);
		CBoardDTO.setCompanyInfo1(companyInfo1);
		CBoardDTO.setCompanyInfo2(companyInfo2);
		CBoardDTO.setCompanyInfo3(companyInfo3);
		CBoardDTO.setRecruitmentDate1(recruitmentDate1);
		CBoardDTO.setRecruitmentDate2(recruitmentDate2);
		CBoardDTO.setPromotionDate1(promotionDate1);
		CBoardDTO.setPromotionDate2(promotionDate2);
		CBoardDTO.setRecruitmentNum(recruitmentNum);
		CBoardDTO.setAvgViewers(avgViewers);
		CBoardDTO.setSubscribers(subscribers);
		CBoardDTO.setSex(sex);
		CBoardDTO.setUnderachiever(underachiever);
		CBoardDTO.setPromotionMoney(promotionMoney);
		CBoardDTO.setPromotionType(promotionType);
		CBoardDTO.setPreviousPromotion1(previousPromotion1);
		CBoardDTO.setPreviousPromotion2(previousPromotion2);
		CBoardDTO.setPreviousPromotion3(previousPromotion3);
		CBoardDTO.setText(text);
		
		SqlInsert insert = SqlInsert.instance();
		insert.sqlInsert(CBoardDTO);
		
		
		
		
		
		
//		System.out.println("제목 " + CBoardDTO.getTitle());
//		System.out.println("담당자정보 " + CBoardDTO.getCompanyInfo1());
//		System.out.println("담당자정보 " + CBoardDTO.getCompanyInfo2());
//		System.out.println("담당자정보 " + CBoardDTO.getCompanyInfo3());
//		System.out.println("모집기간 " + CBoardDTO.getRecruitmentDate1());
//		System.out.println("모집기간 " + CBoardDTO.getRecruitmentDate2());
//		System.out.println("홍보기간 " + CBoardDTO.getPromotionDate1());
//		System.out.println("홍보기간 " + CBoardDTO.getPromotionDate2());
//		System.out.println("모집인원 " + CBoardDTO.getRecruitmentNum());
//		System.out.println("평균시청자 " + CBoardDTO.getAvgViewers());
//		System.out.println("구독자 " + CBoardDTO.getSubscribers());
//		System.out.println("성별 " + CBoardDTO.getSex());
//		System.out.println("미달자   " + CBoardDTO.getUnderachiever());
//		System.out.println("광고진행비 " + CBoardDTO.getPromotionMoney());
//		System.out.println("광고유형 " + CBoardDTO.getPromotionType());
//		System.out.println("이전광고사례 " + CBoardDTO.getPreviousPromotion1());
//		System.out.println("이전광고사례 " + CBoardDTO.getPreviousPromotion2());
//		System.out.println("이전광고사례 " + CBoardDTO.getPreviousPromotion3());
//		System.out.println("내용 " + CBoardDTO.getText());
	
		
		System.out.println("test2");

		return null;
}
}
