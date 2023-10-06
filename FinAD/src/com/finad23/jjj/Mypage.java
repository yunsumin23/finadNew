package com.finad23.jjj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Mypage {
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	
	
//	?Όλ°μ ?? ?°?΄?° μΆμΆ
	public Nomal_info nomal_user(String id) {
		Nomal_info nomal_user = new Nomal_info();
		try {
			getcon();
//			java?? jdbcλ₯? ?¬?©?΄? ?°?΄?°λ² μ΄?€?? ??Έ ??©?  ? ?¬?©?? μ½λ
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from nomal_user where nomalUserId = '" + id + "';");
			if(resultSet.next()) {
				nomal_user.setId(resultSet.getString("nomalUserId"));
				nomal_user.setName(resultSet.getString("name"));
				nomal_user.setEmail(resultSet.getString("eMail"));
				nomal_user.setMobilenumber(resultSet.getString("mobileNumber"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return nomal_user;
	}
	
//	?Έ?λ£¨μΈ? ?°?΄?° μΆμΆ
	public Influ_info influ(String id) {
		Influ_info influ_info = new Influ_info();
		try {
			getcon();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from user where influUserId = '" + id + "';");
			if(resultSet.next()) {
				influ_info.setNickname(resultSet.getString("nickName"));
				influ_info.setName(resultSet.getString("name"));
				influ_info.setEmail(resultSet.getString("eMail"));
				influ_info.setMobilenumber(resultSet.getString("mobileNumber"));
				influ_info.setCategory(resultSet.getString("category"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return influ_info;
	}

//	?Έ?λ£¨μΈ? λ§μ΄??΄μ§? μΆκ? ? λ³?
	public Mypage_influ influ_mypage(String id) {
		Mypage_influ mypage_influ = new Mypage_influ();
		try {
			getcon();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from user_mypage where influUserId = '" + id + "';");
			if(resultSet.next()) {
				mypage_influ.setImage(resultSet.getString("image"));
				mypage_influ.setSubscri(resultSet.getInt("subscribers"));
				mypage_influ.setYoutuLink(resultSet.getString("youtubeLink"));
				mypage_influ.setLiveBcLink(resultSet.getString("liveBroadcastLink"));
				mypage_influ.setSnsLink(resultSet.getString("snsLink"));
				mypage_influ.setIntroduc(resultSet.getString("introduction"));
				mypage_influ.setAvgviewers(resultSet.getInt("avgviewers"));
				mypage_influ.setThravgSub(resultSet.getInt("30avgSub"));
				mypage_influ.setThravgViewer(resultSet.getInt("30avgViewer"));
				mypage_influ.setThravgHit(resultSet.getInt("30avgHits"));
				mypage_influ.setMan_ratio(resultSet.getDouble("man_ratio"));
				mypage_influ.setWoman_ratio(resultSet.getDouble("woman_ratio"));
				mypage_influ.setTenAge(resultSet.getDouble("ageAvg10"));
				mypage_influ.setTweAge(resultSet.getDouble("ageAvg20"));
				mypage_influ.setThrAge(resultSet.getDouble("ageAvg30"));
				mypage_influ.setForAge(resultSet.getDouble("ageAvg40"));
				mypage_influ.setFifAge(resultSet.getDouble("ageAvg50"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return mypage_influ;
	}
	
//	κΈ°μ?? ?°?΄?° μΆμΆ
	public Company_info company(String id) {
		Company_info company_info = new Company_info();
		try {
			getcon();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from company where companyId = '" + id + "';");
			if(resultSet.next()) {
				company_info.setComname(resultSet.getString("companyName"));
				company_info.setName(resultSet.getString("name"));
				company_info.setComemail(resultSet.getString("eMail"));
				company_info.setComnumber(resultSet.getString("telephoneNumber"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return company_info;
	}
	
	
	
	
	
//	μ»€λ₯? ?λ²μ λͺ¨μ?κ±°μ ?°κ³ μΆ?Όλ©? λ©μ? ?ΈμΆνλ©΄λ¨.
	public void getcon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?characterEncoding=utf-8", "root", "123456");
			if(connection == null) {
//				throw? ??Έμ²λ¦¬λ₯? κ°μ λ‘? ??€?κ±°κ³ 
//				throws? λ©μ? ?? ?¬?? ?΄?Ή λ©μ?κ°? ?΄?€ ??Έλ₯? ?μ§? ? ??μ§?λ₯? ? ?Έ?? ?° ?¬?©??€!
				throw new Exception("?°?΄?°λ² μ΄?€ ?°κ²? ??¨.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
//	?΄λ‘μ¦ ? λΆ? λͺ¨μ?κ±°μ finally ? ?? ?Έ?Ό?΄? ?΄ λ©μ? ?ΈμΆνλ©? ?¨.
	public void close() {
		try {
			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
