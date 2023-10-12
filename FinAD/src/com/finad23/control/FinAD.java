package com.finad23.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FinAD extends HttpServlet { // 서블릿 페이지 입니다.

	@Override
	protected void service(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = rq.getParameter("url");
		String cat = rq.getParameter("cat");
		String filter= rq.getParameter("filter");
		// 카테고리 넘어갈 때 어떤 type인지에 따라 보여지는 크리에이터가 다르게 설정 해둔거임
		System.out.println(url);
		System.out.println(cat);
		System.out.println(filter);
		ConInter inter = null;
		// 인터페이스용 주머니 입니다. 확인하시고 또 다시 만들지 마요 / 싫은데요?
		
		if (url.equals("select")) {
			inter = CBoardExtr.instance();
			try {
				String n = inter.FinAD(rq, rs);
				RequestDispatcher re = rq.getRequestDispatcher("company_board.jsp");
				re.forward(rq, rs);
			} catch (Exception e) {
				System.out.println(e);
			}
		} else if(url.equals("beauty")) {
			if (cat == null || cat.equals(null)) {
			inter = CategoryExtr.instance();
			try {
				String category1 = inter.FinAD(rq, rs);
				RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
				re.forward(rq, rs);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			} else if (cat.equals("beauty")){
				if (filter.equals("true")) {
					inter = CategoryFilterExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("ss.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		} else if(url.equals("food")) {
			if(cat == null || cat.equals(null)) {
			inter = CategoryExtr.instance();
			try {
				String category1 = inter.FinAD(rq, rs);
				RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
				re.forward(rq, rs);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			} else if (cat.equals("food")) {
				if (filter.equals("true")) {
					inter = CategoryFilterExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("ss.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		} else if(url.equals("BJ")) {
			if(cat == null || cat.equals(null)) {
			inter = CategoryExtr.instance();
			try {
				String category1 = inter.FinAD(rq, rs);
				RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
				re.forward(rq, rs);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			} else if (cat.equals("BJ")) {
				if(filter.equals("true")) {
					inter = CategoryFilterExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("ss.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		} else if(url.equals("vlog")) {
			if(cat == null || cat.equals(null)) {
			inter = CategoryExtr.instance();
			try {
				String category1 = inter.FinAD(rq, rs);
				RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
				re.forward(rq, rs);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			} else if (cat.equals("vlog")) {
				if(filter.equals("true")) {
					inter = CategoryFilterExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("ss.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		} else if(url.equals("game")) {
			if(cat == null || cat.equals(null)) {
			inter = CategoryExtr.instance();
			try {
				String category1 = inter.FinAD(rq, rs);
				RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
				re.forward(rq, rs);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			} else if (cat.equals("game")) {
				if(filter.equals("true")) {
					inter = CategoryFilterExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("ss.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		} else if(url.equals("IT")) {
			if(cat == null || cat.equals(null)) {
			inter = CategoryExtr.instance();
			try {
				String category1 = inter.FinAD(rq, rs);
				RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
				re.forward(rq, rs);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			} else if (cat.equals("IT")) {
				if(filter.equals("true")) {
					inter = CategoryFilterExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("ss.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		} else if(url.equals("music")) {
			inter = CategoryExtr.instance();
			try {
				String category1 = inter.FinAD(rq, rs);
				RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
				re.forward(rq, rs);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		} else if(url.equals("cook")) {
			inter = CategoryExtr.instance();
			try {
				String category1 = inter.FinAD(rq, rs);
				RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
				re.forward(rq, rs);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		} else if(url.equals("travel")) {
			inter = CategoryExtr.instance();
			try {
				String category1 = inter.FinAD(rq, rs);
				RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
				re.forward(rq, rs);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		} else if(url.equals("pet")) {
			inter = CategoryExtr.instance();
			try {
				String category1 = inter.FinAD(rq, rs);
				RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
				re.forward(rq, rs);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		} else if(url.equals("sports")) {
			inter = CategoryExtr.instance();
			try {
				String category1 = inter.FinAD(rq, rs);
				RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
				re.forward(rq, rs);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		} else if(url.equals("movie")) {
			inter = CategoryExtr.instance();
			try {
				String category1 = inter.FinAD(rq, rs);
				RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
				re.forward(rq, rs);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		} else if(url.equals("car")) {
			inter = CategoryExtr.instance();
			try {
				String category1 = inter.FinAD(rq, rs);
				RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
				re.forward(rq, rs);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		} else if(url.equals("kid")) {
			inter = CategoryExtr.instance();
			try {
				String category1 = inter.FinAD(rq, rs);
				RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
				re.forward(rq, rs);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		} else if(url.equals("education")) {
			inter = CategoryExtr.instance();
			try {
				String category1 = inter.FinAD(rq, rs);
				RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
				re.forward(rq, rs);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		} else if(url.equals("realestate")) {
			inter = CategoryExtr.instance();
			try {
				String category1 = inter.FinAD(rq, rs);
				RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
				re.forward(rq, rs);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		} else if(url.equals("politics")) {
			inter = CategoryExtr.instance();
			try {
				String category1 = inter.FinAD(rq, rs);
				RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
				re.forward(rq, rs);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		} else if(url.equals("palette")) {
			inter = CategoryExtr.instance();
			try {
				String category1 = inter.FinAD(rq, rs);
				RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
				re.forward(rq, rs);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		} else if(url.equals("clover")) {
			inter = CategoryExtr.instance();
			try {
				String category1 = inter.FinAD(rq, rs);
				RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
				re.forward(rq, rs);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		} else if(url.equals("another")) {
			inter = CategoryExtr.instance();
			try {
				String category1 = inter.FinAD(rq, rs);
				RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
				re.forward(rq, rs);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}

	}

}
