package com.finad23.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finad23.jjj.Influ_info;
import com.finad23.mybatis.CategoryFilterConn;

public class CategoryFilterExtr implements ConInter { // DB처리하는 파일
	static CategoryFilterExtr extr = new CategoryFilterExtr();

	public static CategoryFilterExtr instance() {
		return extr;
	}

	@Override
	public String FinAD(HttpServletRequest rq, HttpServletResponse rs) throws Exception {
		// TODO Auto-generated method stub
		CategoryFilterConn conn = CategoryFilterConn.instance();

		Influ_info filter = new Influ_info();

		String shorts = rq.getParameter("shorts");
		String sub = rq.getParameter("sub");
		String price = rq.getParameter("price");
		String avg = rq.getParameter("avg");
		String offer = rq.getParameter("offer");
		String price_name = rq.getParameter("price_name");

		if (shorts.equalsIgnoreCase("true")) {
			shorts = "true";
		} else if (shorts.equalsIgnoreCase("false")) {
			shorts = "false";
		}

		if (sub.equalsIgnoreCase("under10")) {
			sub = "under10";
		} else if (sub.equalsIgnoreCase("over10")) {
			sub = "over10";
		} else if (sub.equalsIgnoreCase("over20")) {
			sub = "over20";
		} else if (sub.equalsIgnoreCase("over50")) {
			sub = "over50";
		} else if (sub.equalsIgnoreCase("over100")) {
			sub = "over100";
		}

		if (price.equalsIgnoreCase("min_price")) {
			price = "min_price";
		} else if (price.equalsIgnoreCase("max_price")) {
			price = "max_price";
		}

		if (avg.equalsIgnoreCase("min_avg")) {
			avg = "min_avg";
		} else if (avg.equalsIgnoreCase("max_avg")) {
			avg = "max_avg";
		}

		if (offer.equalsIgnoreCase("over1")) {
			offer = "over1";
		} else if (offer.equalsIgnoreCase("over10")) {
			offer = "over10";
		} else if (offer.equalsIgnoreCase("over50")) {
			offer = "over50";
		} else if (offer.equalsIgnoreCase("over99")) {
			offer = "over99";
		}


		List<Influ_info> list = conn.filter(filter);

		return null;
	}

}
