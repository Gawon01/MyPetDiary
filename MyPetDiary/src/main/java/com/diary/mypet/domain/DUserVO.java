package com.diary.mypet.domain;

// DUser ���̺��� ������ ����

public class DUserVO {

	// 1. �÷� ���� ����
	private String id;
	private String pw;
	private String profile;
	private String nickname;

	// 2. get set
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	// 3. toString()
	@Override
	public String toString() {
		return "DUserVO [id=" + id + ", pw=" + pw + ", profile=" + profile + ", nickname=" + nickname + "]";
	}

}