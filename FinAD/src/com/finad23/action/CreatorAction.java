package com.finad23.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finad23.VO.ActionForward;
import com.finad23.jjj.Influ_info;
import com.finad23.svc.CreatorService;

public class CreatorAction implements FinadAction{

	@Override
	public ActionForward excute(HttpServletRequest rq, HttpServletResponse rs) throws Exception {
		// TODO Auto-generated method stub
		
		String nickname = rq.getParameter("nickname");
		CreatorService creatorService = new CreatorService();
		Influ_info article = creatorService.getArticle(nickname);
//		System.out.println("action페이지 " + nickname);
		ActionForward forward = new ActionForward();
		rq.setAttribute("nickname", nickname);
		rq.setAttribute("article", article);
		forward.setPath("/test01.jsp");
		return forward;
	}
	
}