package com.finad23.DTO;

public class UserLikeDTO {

	private String likeUser, userNickname, like; // 관심 누른 사람, 눌러진 크리에이터 닉네임, 관심 눌러졌는지 파악

	public String getLikeUser() {
		return likeUser;
	}
	public void setLikeUser(String likeUser) {
		this.likeUser = likeUser;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
}
