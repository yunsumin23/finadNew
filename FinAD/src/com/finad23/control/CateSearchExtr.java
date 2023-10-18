package com.finad23.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finad23.DTO.CateSearchDTO;
import com.finad23.mybatis.CateSearchConn;

public class CateSearchExtr implements ConInter{
	static CateSearchExtr extr = new CateSearchExtr();
	
	public static CateSearchExtr instance() {
		return extr;
	}

	@Override
	public String FinAD(HttpServletRequest rq, HttpServletResponse rs) throws Exception {
		// TODO Auto-generated method stub
		CateSearchConn conn = CateSearchConn.instance();
		
		CateSearchDTO searchDTO = new CateSearchDTO();
		String search = rq.getParameter("cate_search");
		
		searchDTO.setSearch(search);
		
		List<CateSearchDTO> list = conn.search(searchDTO);
		
		rq.setAttribute("List", list);
		
		System.out.println("검색어 입력 " + search);
		return null;
	}
	
}
