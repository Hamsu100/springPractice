package com.so.hard.board.model.vo;

import java.util.Date;
import java.util.List;

public class Board {

	private int bNo;
	private String title;
	private String content;
	private Date crtDate;
	private String ori;
	private String ren;

	private String userId;

	private List<Reply> reply;

	public Board() {
		super();
	}

	public Board(int bNo, String title, String content, Date crtDate, String ori, String ren, String userId,
			List<Reply> reply) {
		super();
		this.bNo = bNo;
		this.title = title;
		this.content = content;
		this.crtDate = crtDate;
		this.ori = ori;
		this.ren = ren;
		this.userId = userId;
		this.reply = reply;
	}

	public List<Reply> getReply() {
		return reply;
	}

	public void setReply(List<Reply> reply) {
		this.reply = reply;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
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

	public Date getCrtDate() {
		return crtDate;
	}

	public void setCrtDate(Date crtDate) {
		this.crtDate = crtDate;
	}

	public String getOri() {
		return ori;
	}

	public void setOri(String ori) {
		this.ori = ori;
	}

	public String getRen() {
		return ren;
	}

	public void setRen(String ren) {
		this.ren = ren;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
