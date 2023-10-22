package com.finad23.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finad23.VO.ActionForward;
import com.finad23.action.CreatorAct;
import com.finad23.action.FinadAction;

@WebServlet("*finad")
public class FinadFrontContorller extends javax.servlet.http.HttpServlet {
	protected void doProcess(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		rq.setCharacterEncoding("UTF-8");
		String RequestURi = rq.getRequestURI();
		String contextPath = rq.getContextPath();
		String command = RequestURi.substring(contextPath.length());
		ActionForward forward = null;
		FinadAction action = null;

		if (command.equals("/creator.finad")) {
			action = new CreatorAct();
			try {
				forward = action.excute(rq, rs);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
