package com.diary.mypet.domain;

import java.sql.Date;

// Diary ���̺� �����ͺ��̽� ���� Ŭ���� 

public class DiaryVO {

	// 1. �÷� �̸��� ������ ���� ����
	private int no;
	private String title;
	private String content;
	private String nickname;
	private int readcnt;
	private Date regdate;

	// 2. Getter, Setter �޼ҵ� ����
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	// 3. toString() ������ -> �ڵ� �׽�Ʈ�� ����
	@Override
	public String toString() {
		return "DiaryVO [no=" + no + ", title=" + title + ", content=" + content + ", nickname=" + nickname
				+ ", readcnt=" + readcnt + ", regdate=" + regdate + "]";
	}

}
