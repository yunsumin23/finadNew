package com.finad23.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finad23.VO.ActionForward;

public class DiffCreAction implements FinadAction{

	@Override
	public ActionForward excute(HttpServletRequest rq, HttpServletResponse rs) throws Exception {
		// TODO Auto-generated method stub
		rq.setCharacterEncoding("UTF-8");
		String nickname = rq.getParameter("nickname");
		
		
		return null;
	}

}
