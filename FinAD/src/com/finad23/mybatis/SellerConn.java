package com.finad23.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.finad23.DTO.AdstoreReviewDTO;

public class SellerConn {
    static SellerConn sellerConn = new SellerConn();
    public static SellerConn instance() {
        return sellerConn;
    }

    SqlSessionFactory sqlsession = SqlConnect.getSqlSession();

    public List<AdstoreReviewDTO> sqlSelect(AdstoreReviewDTO adr) {
        SqlSession sqlSession = sqlsession.openSession();

        List<AdstoreReviewDTO> list = sqlSession.selectList("itemReviewNumber", adr);
        sqlSession.close();
        return list;

	}
}
