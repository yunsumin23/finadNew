package com.finad23.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.finad23.DTO.AdstoreReviewDTO;
import com.finad23.mybatis.SellerConn;

public class SellerExtr implements ConInter {
    static SellerExtr extr = new SellerExtr();
    public static SellerExtr instance() {
        return extr;
    }

    @Override
    public String FinAD(HttpServletRequest rq, HttpServletResponse rs) throws Exception {
        SellerConn conn = SellerConn.instance();
       
        String sell = rq.getParameter("url");
        AdstoreReviewDTO adr = new AdstoreReviewDTO();
        List<AdstoreReviewDTO> list = conn.sqlSelect(adr);
        
        rq.setAttribute("List", list);
        return null;
    }
}
