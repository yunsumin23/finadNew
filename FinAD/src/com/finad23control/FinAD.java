package com.finad23control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FinAD extends HttpServlet { // ?λΈλ¦Ώ ??΄μ§? ???€.

	@Override
	protected void service(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String category = rq.getParameter("type");
		String companyBoard = rq.getParameter("companyBoardInput");
		// μΉ΄νκ³ λ¦¬ ??΄κ°? ? ?΄?€ type?Έμ§?? ?°?Ό λ³΄μ¬μ§?? ?¬λ¦¬μ?΄?°κ°? ?€λ₯΄κ²
		// ?€?  ?΄?κ±°μ

		ConInter inter = null;
		// ?Έ?°??΄?€?© μ£Όλ¨Έ? ???€. ??Έ??κ³? ? ?€? λ§λ€μ§? λ§μ / ?«???°??

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
