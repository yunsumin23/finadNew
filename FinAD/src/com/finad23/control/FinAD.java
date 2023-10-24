package com.finad23.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.finad23.action.FinadAction;

import com.finad23.action.BoardListAction;
//import com.finad23.action.CreatorAct;
import com.finad23.VO.ActionForward;

public class FinAD extends HttpServlet { // 서블릿 페이지 입니다.

	@Override
	protected void service(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = rq.getParameter("url");
		String cat = rq.getParameter("cat");
		String filter = rq.getParameter("filter");
		String catesearch = rq.getParameter("catesearch");
		// 카테고리 넘어갈 때 어떤 type인지에 따라 보여지는 크리에이터가 다르게 설정 해둔거임
		System.out.println("url " + url);
		System.out.println("cat " + cat);
		System.out.println("filter " + filter);
		System.out.println("catesearch " + catesearch);
		ConInter inter = null;
		//.bo
//		rq.setCharacterEncoding("UTF-8");
//		String RequestURI=rq.getRequestURI();
//		String contextPath=rq.getContextPath();
//		String command=RequestURI.substring(contextPath.length());
//		ActionForward forward=null;
//		FinadAction action=null;
		// 인터페이스용 주머니 입니다. 확인하시고 또 다시 만들지 마요 / 싫은데요?

		if (url.equals("CBoard")) {
			inter = CBoardExtr.instance();
			try {
				String cboard = inter.FinAD(rq, rs);
				RequestDispatcher re = rq.getRequestDispatcher("company_board.jsp");
				re.forward(rq, rs);
			} catch (Exception e) {
				System.out.println(e);
			}
		}else if (url.equals("CBoardWrite")) {
			inter = CBoardExtr.instance();
			try {
				String cboardWrite = inter.FinAD(rq, rs);
				RequestDispatcher re = rq.getRequestDispatcher("company_board_write.jsp");
				re.forward(rq, rs);
			} catch (Exception e) {
				System.out.println(e);
			}
		}else if (url.equals("CBoardWrited")) {
			inter = CBoardInsert.instance();
			try {
				String cboardWrited = inter.FinAD(rq, rs);
				RequestDispatcher re = rq.getRequestDispatcher("test01.jsp");
				re.forward(rq, rs);
			} catch (Exception e) {
				System.out.println(e);
			}
		} else if (url.equals("beauty")) {
			if (cat == null) {
				inter = CategoryExtr.instance();
				try {
					String category1 = inter.FinAD(rq, rs);
					RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
					re.forward(rq, rs);
				} catch (Exception e) {
					System.out.println(e);
				}
			} else if (cat.equals("beauty")) {
				if (filter != null && filter.equals("true")) {
					inter = CategoryFilterExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("ss.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						System.out.println(e);
					}
				} else if (catesearch != null && catesearch.equals("true")) {
					inter = CateSearchExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("cateSearch.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						System.out.println("연결안됨");
					}
				}
			}
		} else if (url.equals("food")) {
			if (cat == null) {
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
				if (filter != null && filter.equals("true")) {
					inter = CategoryFilterExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("ss.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else if (catesearch != null && catesearch.equals("true")) {
					inter = CateSearchExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("cateSearch.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						System.out.println("연결안됨");
					}
				}
			}
		} else if (url.equals("BJ")) {
			if (cat == null) {
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
				if (filter != null && filter.equals("true")) {
					inter = CategoryFilterExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("ss.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else if (catesearch != null && catesearch.equals("true")) {
					inter = CateSearchExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("cateSearch.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						System.out.println("연결안됨");
					}
				}
			}
		} else if (url.equals("vlog")) {
			if (cat == null) {
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
				if (filter != null && filter.equals("true")) {
					inter = CategoryFilterExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("ss.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else if (catesearch != null && catesearch.equals("true")) {
					inter = CateSearchExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("cateSearch.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						System.out.println("연결안됨");
					}
				}
			}
		} else if (url.equals("game")) {
			if (cat == null) {
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
				if (filter != null && filter.equals("true")) {
					inter = CategoryFilterExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("ss.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else if (catesearch != null && catesearch.equals("true")) {
					inter = CateSearchExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("cateSearch.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						System.out.println("연결안됨");
					}
				}
			}
		} else if (url.equals("IT")) {
			if (cat == null) {
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
				if (filter != null && filter.equals("true")) {
					inter = CategoryFilterExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("ss.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else if (catesearch != null && catesearch.equals("true")) {
					inter = CateSearchExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("cateSearch.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						System.out.println("연결안됨");
					}
				}
			}
		} else if (url.equals("music")) {
			if (cat == null) {
				inter = CategoryExtr.instance();
				try {
					String category1 = inter.FinAD(rq, rs);
					RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
					re.forward(rq, rs);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			} else if (cat.equals("music")) {
				if (filter != null && filter.equals("true")) {
					inter = CategoryFilterExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("ss.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else if (catesearch != null && catesearch.equals("true")) {
					inter = CateSearchExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("cateSearch.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						System.out.println("연결안됨");
					}
				}
			}
		} else if (url.equals("cook")) {
			if (cat == null) {
				inter = CategoryExtr.instance();
				try {
					String category1 = inter.FinAD(rq, rs);
					RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
					re.forward(rq, rs);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			} else if (cat.equals("cook")) {
				if (filter != null && filter.equals("true")) {
					inter = CategoryFilterExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("ss.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else if (catesearch != null && catesearch.equals("true")) {
					inter = CateSearchExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("cateSearch.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						System.out.println("연결안됨");
					}
				}
			}
		} else if (url.equals("travel")) {
			if (cat == null) {
				inter = CategoryExtr.instance();
				try {
					String category1 = inter.FinAD(rq, rs);
					RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
					re.forward(rq, rs);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			} else if (cat.equals("travel")) {
				if (filter != null && filter.equals("true")) {
					inter = CategoryFilterExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("ss.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else if (catesearch != null && catesearch.equals("true")) {
					inter = CateSearchExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("cateSearch.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						System.out.println("연결안됨");
					}
				}
			}
		} else if (url.equals("pet")) {
			if (cat == null) {
				inter = CategoryExtr.instance();
				try {
					String category1 = inter.FinAD(rq, rs);
					RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
					re.forward(rq, rs);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			} else if (cat.equals("pet")) {
				if (filter != null && filter.equals("true")) {
					inter = CategoryFilterExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("ss.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else if (catesearch != null && catesearch.equals("true")) {
					inter = CateSearchExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("cateSearch.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						System.out.println("연결안됨");
					}
				}
			}
		} else if (url.equals("sports")) {
			if (cat == null) {
				inter = CategoryExtr.instance();
				try {
					String category1 = inter.FinAD(rq, rs);
					RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
					re.forward(rq, rs);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			} else if (cat.equals("sports")) {
				if (filter != null && filter.equals("true")) {
					inter = CategoryFilterExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("ss.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else if (catesearch != null && catesearch.equals("true")) {
					inter = CateSearchExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("cateSearch.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						System.out.println("연결안됨");
					}
				}
			}
		} else if (url.equals("movie")) {
			if (cat == null) {
				inter = CategoryExtr.instance();
				try {
					String category1 = inter.FinAD(rq, rs);
					RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
					re.forward(rq, rs);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			} else if (cat.equals("movie")) {
				if (filter != null && filter.equals("true")) {
					inter = CategoryFilterExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("ss.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else if (catesearch != null && catesearch.equals("true")) {
					inter = CateSearchExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("cateSearch.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						System.out.println("연결안됨");
					}
				}
			}
		} else if (url.equals("car")) {
			if (cat == null) {
				inter = CategoryExtr.instance();
				try {
					String category1 = inter.FinAD(rq, rs);
					RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
					re.forward(rq, rs);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			} else if (cat.equals("car")) {
				if (filter != null && filter.equals("true")) {
					inter = CategoryFilterExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("ss.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else if (catesearch != null && catesearch.equals("true")) {
					inter = CateSearchExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("cateSearch.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						System.out.println("연결안됨");
					}
				}
			}
		} else if (url.equals("kid")) {
			if (cat == null) {
				inter = CategoryExtr.instance();
				try {
					String category1 = inter.FinAD(rq, rs);
					RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
					re.forward(rq, rs);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			} else if (cat.equals("kid")) {
				if (filter != null && filter.equals("true")) {
					inter = CategoryFilterExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("ss.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else if (catesearch != null && catesearch.equals("true")) {
					inter = CateSearchExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("cateSearch.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						System.out.println("연결안됨");
					}
				}
			}
		} else if (url.equals("education")) {
			if (cat == null) {
				inter = CategoryExtr.instance();
				try {
					String category1 = inter.FinAD(rq, rs);
					RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
					re.forward(rq, rs);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			} else if (cat.equals("education")) {
				if (filter != null && filter.equals("true")) {
					inter = CategoryFilterExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("ss.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else if (catesearch != null && catesearch.equals("true")) {
					inter = CateSearchExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("cateSearch.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						System.out.println("연결안됨");
					}
				}
			}
		} else if (url.equals("realestate")) {
			if (cat == null) {
				inter = CategoryExtr.instance();
				try {
					String category1 = inter.FinAD(rq, rs);
					RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
					re.forward(rq, rs);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			} else if (cat.equals("realestate")) {
				if (filter != null && filter.equals("true")) {
					inter = CategoryFilterExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("ss.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else if (catesearch != null && catesearch.equals("true")) {
					inter = CateSearchExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("cateSearch.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						System.out.println("연결안됨");
					}
				}
			}
		} else if (url.equals("politics")) {
			if (cat == null) {
				inter = CategoryExtr.instance();
				try {
					String category1 = inter.FinAD(rq, rs);
					RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
					re.forward(rq, rs);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			} else if (cat.equals("politics")) {
				if (filter != null && filter.equals("true")) {
					inter = CategoryFilterExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("ss.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else if (catesearch != null && catesearch.equals("true")) {
					inter = CateSearchExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("cateSearch.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						System.out.println("연결안됨");
					}
				}
			}
		} else if (url.equals("palette")) {
			if (cat == null) {
				inter = CategoryExtr.instance();
				try {
					String category1 = inter.FinAD(rq, rs);
					RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
					re.forward(rq, rs);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			} else if (cat.equals("palette")) {
				if (filter != null && filter.equals("true")) {
					inter = CategoryFilterExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("ss.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else if (catesearch != null && catesearch.equals("true")) {
					inter = CateSearchExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("cateSearch.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						System.out.println("연결안됨");
					}
				}
			}
		} else if (url.equals("clover")) {
			if (cat == null) {
				inter = CategoryExtr.instance();
				try {
					String category1 = inter.FinAD(rq, rs);
					RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
					re.forward(rq, rs);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			} else if (cat.equals("clover")) {
				if (filter != null && filter.equals("true")) {
					inter = CategoryFilterExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("ss.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else if (catesearch != null && catesearch.equals("true")) {
					inter = CateSearchExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("cateSearch.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						System.out.println("연결안됨");
					}
				}
			}
		} else if (url.equals("another")) {
			if (cat == null) {
				inter = CategoryExtr.instance();
				try {
					String category1 = inter.FinAD(rq, rs);
					RequestDispatcher re = rq.getRequestDispatcher("category.jsp");
					re.forward(rq, rs);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			} else if (cat.equals("another")) {
				if (filter != null && filter.equals("true")) {
					inter = CategoryFilterExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("ss.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else if (catesearch != null && catesearch.equals("true")) {
					inter = CateSearchExtr.instance();
					try {
						inter.FinAD(rq, rs);
						RequestDispatcher re = rq.getRequestDispatcher("cateSearch.jsp");
						re.forward(rq, rs);
					} catch (Exception e) {
						System.out.println("연결안됨");
					}
				}
			}
		} else if (url.equals("1") || url.equals("2") || url.equals("3") || url.equals("4") || url.equals("5")
				|| url.equals("6") || url.equals("7") || url.equals("8") || url.equals("9")) {
			inter = SellerExtr.instance();
			try {
				String s = inter.FinAD(rq, rs);
				RequestDispatcher re = rq.getRequestDispatcher("sellpage.jsp");
				re.forward(rq, rs);
			} catch (Exception e) {
				System.out.println(e);
			}

	}

	}}
