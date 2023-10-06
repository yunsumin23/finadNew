package com.finad23control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finad23.DTO.CompanyBoardDTO;

public class DBExtract implements ConInter {

	static DBExtract dbExtract = new DBExtract();
	public static DBExtract instance() {
		return dbExtract;
	}
	@Override
	public String FinAD(HttpServletRequest rq, HttpServletResponse rs) throws Exception {
		Select select = Select.instance();
		List<CompanyBoardDTO> list = select.dbSelect();
		rq.setAttribute("List", list);
		
		return null;
	}
}
