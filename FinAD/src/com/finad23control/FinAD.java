package com.finad23control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FinAD extends HttpServlet { // ?„œë¸”ë¦¿ ?˜?´ì§? ?…?‹ˆ?‹¤.

	@Override
	protected void service(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String category = rq.getParameter("type");
		String companyBoard = rq.getParameter("companyBoardInput");
		// ì¹´í…Œê³ ë¦¬ ?„˜?–´ê°? ?•Œ ?–´?–¤ type?¸ì§??— ?”°?¼ ë³´ì—¬ì§??Š” ?¬ë¦¬ì—?´?„°ê°? ?‹¤ë¥´ê²Œ
		// ?„¤? • ?•´?‘”ê±°ì„

		ConInter inter = null;
		// ?¸?„°?˜?´?Š¤?š© ì£¼ë¨¸?‹ˆ ?…?‹ˆ?‹¤. ?™•?¸?•˜?‹œê³? ?˜ ?‹¤?‹œ ë§Œë“¤ì§? ë§ˆìš” / ?‹«???°?š”?

		// <form action="insert.Sql?companyBoardInput=select" method="POST">
		if (companyBoard.equals("select")) {
			inter = DBExtract.instance();
			try {
				String n = inter.FinAD(rq, rs);
				RequestDispatcher re = rq.getRequestDispatcher("companyBoard.jsp");
			} catch (Exception e) {
				System.out.println(e);
			}
		} else if (category.equals("beauty")) {

		} else if (companyBoard.contentEquals("sel")) {

		}
	}

}
