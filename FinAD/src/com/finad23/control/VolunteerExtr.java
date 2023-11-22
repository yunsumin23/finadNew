package com.finad23.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finad23.DTO.CBoardVolunteerDTO;

import com.finad23.mybatis.VolunteerConn;

public class VolunteerExtr implements ConInter { //광고게시판 Extract == 추출이라는 뜻

	static VolunteerExtr dbExtract = new VolunteerExtr();
	public static VolunteerExtr instance() {
		return dbExtract;
	}
	@Override
	public String FinAD(HttpServletRequest rq, HttpServletResponse rs) throws Exception {
		VolunteerConn select = VolunteerConn.instance();
		int vnum = Integer.parseInt(rq.getParameter("number"));
		List<CBoardVolunteerDTO> list = select.dbSelect(vnum);
		rq.setAttribute("List", list);

		return null;
	}
}