package com.so.hard.board.model.vo;

import java.util.Date;

public class Reply {

	private int rNo;
	private int bNo;
	private String content;
	private Date crtDate;
	
	private String userId;

	public Reply() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reply(int rNo, int bNo, String content, Date crtDate, String userId) {
		super();
		this.rNo = rNo;
		this.bNo = bNo;
		this.content = content;
		this.crtDate = crtDate;
		this.userId = userId;
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCrtDate() {
		return crtDate;
	}

	public void setCrtDate(Date crtDate) {
		this.crtDate = crtDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
