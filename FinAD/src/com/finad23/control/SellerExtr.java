package com.finad23.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SellerExtr implements ConInter{
	
	static SellerExtr extr = new SellerExtr();
	public static SellerExtr instance() {
		return extr;
	}
	
	
	
	@Override
	public String FinAD(HttpServletRequest rq, HttpServletResponse rs) throws Exception {
		// TODO Auto-generated method stub
		
		return null;
	}

}
