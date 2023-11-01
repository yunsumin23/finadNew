package com.finad23.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finad23.DTO.CBoardVolunteerDTO;
import com.finad23.mybatis.CBoardVolConn;

public class CBoardVolExtr implements ConInter { //광고게시판 Extract == 추출이라는 뜻

	static CBoardVolExtr dbExtract = new CBoardVolExtr();
	public static CBoardVolExtr instance() {
		return dbExtract;
	}
	@Override
	public String FinAD(HttpServletRequest rq, HttpServletResponse rs) throws Exception {
		CBoardVolConn select = CBoardVolConn.instance();
		List<CBoardVolunteerDTO> list = select.dbSelect();
		rq.setAttribute("List", list);
		
		return null;
	}
}
