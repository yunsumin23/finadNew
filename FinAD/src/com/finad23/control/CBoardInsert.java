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
//		String companyName = rq.getParameter("companyName");
//		String companyInfo1 = rq.getParameter("companyInfo1");
//		String companyInfo2 = rq.getParameter("companyInfo2");
//		String companyInfo3 = rq.getParameter("companyInfo3");
		String recruitmentDate1 = rq.getParameter("recruitmentDate1");
		String recruitmentDate2 = rq.getParameter("recruitmentDate2");
		String promotionDate1 = rq.getParameter("promotionDate1");
		String promotionDate2 = rq.getParameter("promotionDate2");
		String recruitmentNum = rq.getParameter("recruitmentNum");
		String avgViewers = rq.getParameter("avgViewers");
		String subscribers = rq.getParameter("subscribers");
		String sex = rq.getParameter("sex");
		String  underachiever = rq.getParameter("underachiever");
		int promotionMoney = Integer.parseInt(rq.getParameter("promotionMoney"));
		String promotionType = rq.getParameter("promotionType");
		String previousPromotion1 = rq.getParameter("previousPromotion1");
		String previousPromotion2 = rq.getParameter("previousPromotion2");
		String previousPromotion3 = rq.getParameter("previousPromotion3");
		String text = rq.getParameter("text");
		String companyWriteDate = rq.getParameter("companyWriteDate");
		
		CompanyBoardDTO companyBoardDTO = new CompanyBoardDTO();
		companyBoardDTO.setTitle(title);
//		companyBoardDTO.setCompanyName(companyName);
//		companyBoardDTO.setCompanyInfo1(companyInfo1);
//		companyBoardDTO.setCompanyInfo2(companyInfo2);
//		companyBoardDTO.setCompanyInfo3(companyInfo3);
		companyBoardDTO.setRecruitmentDate1(recruitmentDate1);
		companyBoardDTO.setRecruitmentDate2(recruitmentDate2);
		companyBoardDTO.setPromotionDate1(promotionDate1);
		companyBoardDTO.setPromotionDate2(promotionDate2);
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
		companyBoardDTO.setCompanyWriteDate(companyWriteDate);
		
		
		SqlInsert insert = SqlInsert.instance();
		insert.sqlInsert(companyBoardDTO);
		
		return null;
}
}
