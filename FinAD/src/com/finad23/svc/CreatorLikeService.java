package com.finad23.svc;

import java.sql.Connection;

import com.finad23.DAO.FinadDAO;
import com.finad23.DTO.UserLikeDTO;
import static com.finad23.db.JdbcUtil.*;

public class CreatorLikeService {
	
	public UserLikeDTO UserLikeDTO(String nickname, String id) throws Exception {
		UserLikeDTO likeDTO = null;
		Connection conn = getConnection();
		FinadDAO finadDAO = FinadDAO.getInstance();
		finadDAO.setConnection(conn);
		
		likeDTO = finadDAO.creatorLike(nickname, id);
		close(conn);
		return likeDTO;
	}
}
