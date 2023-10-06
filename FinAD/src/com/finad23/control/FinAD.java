package com.finad23.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FinAD extends HttpServlet { // ���� ������ �Դϴ�.

	@Override
	protected void service(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String category = rq.getParameter("type");
		String companyBoard = rq.getParameter("companyBoardInput");
		// ī�װ� �Ѿ �� � type������ ���� �������� ũ�������Ͱ� �ٸ���
		// ���� �صа���

		ConInter inter = null;
		// 인터페이스용 주머니 입니다. 확인하시고 또 다시 만들지 마요 / 싫은데요?
		
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
