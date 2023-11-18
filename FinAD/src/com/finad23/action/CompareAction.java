package com.finad23.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finad23.VO.ActionForward;
import com.finad23.jjj.Influ_info;
import com.finad23.svc.CompareService;

public class CompareAction implements FinadAction{

	@Override
	public ActionForward excute(HttpServletRequest rq, HttpServletResponse rs) throws Exception {
		// TODO Auto-generated method stub
		rq.setCharacterEncoding("UTF-8");
		String nickname = rq.getParameter("nickname");
		
		CompareService creService = new CompareService();
		Influ_info info = creService.diffCre(nickname);
		System.out.println("12345" + nickname);
		ActionForward forward = new ActionForward();
		rq.setAttribute("info", info);
		
		forward.setPath("/compare.jsp");
		
		return forward;
	}

}
