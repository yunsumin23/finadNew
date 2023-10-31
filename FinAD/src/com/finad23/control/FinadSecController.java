package com.finad23.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finad23.VO.ActionForward;
import com.finad23.action.CreatorAction;
import com.finad23.action.FinadAction;
import com.finad23.action.MainSearchAction;

public class FinadSecController extends javax.servlet.http.HttpServlet{
	
	protected void service(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		rq.setCharacterEncoding("UTF-8");
		String RequestURI = rq.getRequestURI();
		String contextPath = rq.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		String abcd = rq.getParameter("main_search");
		FinadAction finadAction = null;
//		System.out.println("1234 "+ abcd);
		if(command.equals("/creator.finad23")) {
			finadAction = new CreatorAction();
			try {
				forward = finadAction.excute(rq, rs);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		} else if (command.equals("/search.finad23")) {
			finadAction = new MainSearchAction();
			try {
				forward = finadAction.excute(rq, rs);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}
		if(forward != null) {
			if(forward.isRedirect()) {
				rs.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = rq.getRequestDispatcher(forward.getPath());
				dispatcher.forward(rq, rs);
			}
		}
	}
}
