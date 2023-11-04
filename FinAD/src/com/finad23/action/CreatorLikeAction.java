package com.finad23.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finad23.DTO.UserLikeDTO;
import com.finad23.VO.ActionForward;
import com.finad23.svc.CreatorLikeService;

public class CreatorLikeAction implements FinadAction{

	@Override
	public ActionForward excute(HttpServletRequest rq, HttpServletResponse rs) throws Exception {
		// TODO Auto-generated method stub
		String nickname = rq.getParameter("nickname");
		String id = rq.getParameter("id");
		String like = rq.getParameter("star01");
		CreatorLikeService likeService = new CreatorLikeService();
		UserLikeDTO likeDTO = likeService.UserLikeDTO(nickname, id);
		
		ActionForward forward = new ActionForward();
		rq.setAttribute("id", id);
//		rq.setAttribute("like", like);
		rq.setAttribute("nickname", nickname);
		rq.setAttribute("likeDTO", likeDTO);
		forward.setPath("/test01.jsp");
		
		return forward;
	}

}
