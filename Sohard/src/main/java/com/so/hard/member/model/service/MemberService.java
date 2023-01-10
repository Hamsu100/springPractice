package com.so.hard.member.model.service;

import java.util.Map;

import com.so.hard.member.model.vo.Member;

public interface MemberService {
	
	public Member login(Map<String,String> map);
	
	public int join(Member member);
	
	public Member findId(String id);

	public boolean modifyMember(Member pwd);
}
