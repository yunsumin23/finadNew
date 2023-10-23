package com.finad23.DAO;

import static com.finad23.db.JdbcUtil.close;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.finad23.DTO.BoardDTO;



// DAO페이지 임니다 기본 양식은 만들어 뒀으니 사용하면 됩니다.


public class FinadDAO {
	DataSource ds;
	Connection con;
	private static FinadDAO finadDAO;
	
	private FinadDAO() {
	}
	
	public static FinadDAO getInstance() {
		if(finadDAO == null) {
			finadDAO = new FinadDAO();
		}
		return finadDAO;
	}
	
	public void setConnection(Connection conn) {
		this.con = con;
	}
	
	public int selectListCount() {

		int listCount= 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			pstmt=con.prepareStatement("select count(*) from board");
			rs = pstmt.executeQuery();

			if(rs.next()){
				listCount=rs.getInt(1);
			}
		}catch(Exception ex){

		}finally{
			close(rs);
			close(pstmt);
		}

		return listCount;

	}
	
	public ArrayList<BoardDTO> selectArticleList(int page,int limit){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_list_sql="select * from freeboard limit ?,10";
		ArrayList<BoardDTO> articleList = new ArrayList<BoardDTO>();
		BoardDTO board = null;
		int startrow=(page-1)*10; 

		try{
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();

			while(rs.next()){
				board = new BoardDTO();
				board.setNumber(rs.getInt("freeboardnumber"));
				board.setWriter(rs.getString("freeboardwriter"));
				board.setName(rs.getString("freeboardname"));
				board.setText(rs.getString("freeboardtext"));
				board.setDate(rs.getString("freeboarddate"));
				board.setView(rs.getInt("freeboardviews"));
				board.setLike(rs.getInt("freeboardLike"));
				articleList.add(board);
			}

		}catch(Exception ex){
		}finally{
			close(rs);
			close(pstmt);
		}

		return articleList;

	}
	
	
}
