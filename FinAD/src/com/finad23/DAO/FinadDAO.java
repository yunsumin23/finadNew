package com.finad23.DAO;

import static com.finad23.db.JdbcUtil.close;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.finad23.DTO.BoardDTO;
import com.finad23.DTO.UserLikeDTO;
import com.finad23.jjj.Influ_info;



// DAO페이지 임니다 기본 양식은 만들어 뒀으니 사용하면 됩니다.


public class FinadDAO {
	DataSource ds;
	Connection conn;
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
		this.conn = conn;
	}
	
	public int selectListCount() {

		int listCount= 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			pstmt=conn.prepareStatement("select count(*) from freeboard");
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
			pstmt = conn.prepareStatement(board_list_sql);
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
	public Influ_info creator(String nickname) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Influ_info influ_info = new Influ_info();
		System.out.println("hhhhh "+nickname);
		try {
			pstmt = conn.prepareStatement(
	                "SELECT user.*, user_mypage.* " +
	                        "FROM project.user LEFT JOIN project.user_mypage " +
	                        "ON user.influUserId = user_mypage.influUserId " +
	                        "WHERE user.nickName LIKE ? " +
	                        "ORDER BY user_mypage.subscribers DESC");

	        pstmt.setString(1, "%" + nickname + "%");
			rs = pstmt.executeQuery();
			System.out.println("ㅗㅗㅗㅗㅗㅗㅗ"+nickname);
			if(rs.next()) {
				influ_info.setNickname(rs.getString("nickName"));
				influ_info.setCategory(rs.getString("category"));
				influ_info.setSubscribers(rs.getInt("subscribers"));
				influ_info.setImage(rs.getString("image"));
				influ_info.setYoutuLink(rs.getString("youtubeLink"));
				influ_info.setLiveBcLink(rs.getString("liveBroadcastLink"));
				influ_info.setSnsLink(rs.getString("snsLink"));
				influ_info.setIntroduc(rs.getString("introduction"));
				influ_info.setAvgviewers(rs.getInt("avgviewers"));
				influ_info.setThravgSub(rs.getInt("30avgSub"));
				influ_info.setThravgViewer(rs.getInt("30avgViewer"));
				influ_info.setThravgHit(rs.getInt("30avgHits"));
				influ_info.setMan_ratio(rs.getDouble("man_ratio"));
				influ_info.setWoman_ratio(rs.getDouble("woman_ratio"));
				influ_info.setTenAge(rs.getDouble("ageAvg10"));
				influ_info.setTweAge(rs.getDouble("ageAvg20"));
				influ_info.setThrAge(rs.getDouble("ageAvg30"));
				influ_info.setForAge(rs.getDouble("ageAvg40"));
				influ_info.setFifAge(rs.getDouble("ageAvg50"));
				System.out.println("ㅜㅜㅜㅜㅜㅜ"+influ_info.getNickname());
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			close(rs);
			close(pstmt);
		}
		return influ_info;
	}
	
	public ArrayList<Influ_info> search(String nickname) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String search = "SELECT user.*, user_mypage.*, FORMAT(user_mypage.subscribers, 0) AS subscribers "  
	            + "FROM project.user LEFT JOIN project.user_mypage ON user.influUserId = user_mypage.influUserId " 
	            + "WHERE user.nickName LIKE CONCAT('%" + nickname + "%') " 
	            + "ORDER BY user_mypage.subscribers DESC;";
		ArrayList<Influ_info> list = new ArrayList<Influ_info>();
		Influ_info influ_info = null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			pstmt = conn.prepareStatement(search);
			rs = pstmt.executeQuery();
//			System.out.println("dao " + nickname);
			while(rs.next()) {
				influ_info = new Influ_info();
				influ_info.setNickname(rs.getString("nickName"));
				influ_info.setSubscribers(rs.getInt("subscribers"));
				influ_info.setAvgviewers(rs.getInt("avgviewers"));
				influ_info.setImage(rs.getString("image"));
				list.add(influ_info);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public int creatorLike(UserLikeDTO likeDTO) {
		PreparedStatement pstmt = null;
		int likeCount = 0;
		String id = likeDTO.getId();
		String nickname = likeDTO.getNickName();
		try {
			pstmt = conn.prepareStatement(
		            "INSERT INTO project.userlike (id, nickName, like1) VALUES (?, ?, '1')");
		        pstmt.setString(1, id);
		        pstmt.setString(2, nickname);
		        likeCount = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.print(e);
		} finally {
			try {
				close(pstmt);
			} catch(Exception e) {
				System.out.print(e);
			}
		}
		System.out.println("3ㅗㅗㅗㅗ");
		return likeCount;
	}
	
	public void abcd() {
		
	}
}