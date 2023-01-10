package com.so.hard.member.model.vo;

public class Member {
	private int idNo;
	private String id;
	private String password;

	public Member() {
		super();
	}

	public Member(int idNo, String id, String password) {
		super();
		this.idNo = idNo;
		this.id = id;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Member [idNo=" + idNo + ", id=" + id + ", password=" + password + "]";
	}

	public int getIdNo() {
		return idNo;
	}

	public void setIdNo(int idNo) {
		this.idNo = idNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
