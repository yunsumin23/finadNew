package com.finad23.jjj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.finad23.DTO.BoardDTO;



public class FreeBoard {
	
	public Connection con() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?characterEncoding=utf-8", "root", "123456");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public void dicon(Statement statement, Connection connection) { //λ§€κ°λ³??
		try {
			statement.close();
		}catch (Exception ignored) {
			// TODO: handle exception
		}
		try {
			connection.close();
		} catch (Exception ignored) {
			// TODO: handle exception
		}
	}
	
//κ²μ? ?°?΄?°λ₯? κ°?? Έ?€? λ©μ?
	public ArrayList<BoardDTO> getBoardList() {
//		ArrayList<BoardDTO> boardList = new ArrayList<>();
		// ?°?΄?°λ² μ΄?€ ?°κ²? λ°? μΏΌλ¦¬ ?€?
		Connection connection = con();
		Statement statement = null;
		ResultSet resultSet = null;
		// κ²°κ³Όλ₯? BoardDTO κ°μ²΄λ‘? λ³????¬ boardList? μΆκ?
		ArrayList<BoardDTO> arr = new ArrayList<BoardDTO>();
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from project.freeboard;");
			while(resultSet.next()) {
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setNumber(resultSet.getInt("freeboardnumber"));
				boardDTO.setWriter(resultSet.getString("freeboardwriter"));
				boardDTO.setName(resultSet.getString("freeboardname"));
				boardDTO.setText(resultSet.getString("freeboardtext"));
				boardDTO.setDate(resultSet.getString("freeboarddate"));
				arr.add(boardDTO);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			dicon(statement, connection);
		}
		return arr;
	}
}