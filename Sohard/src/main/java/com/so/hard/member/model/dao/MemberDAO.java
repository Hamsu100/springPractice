package com.so.hard.member.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import com.so.hard.member.model.vo.Member;

public interface MemberDAO {
	// 1. 로그인 기능 + 회원가입 기능
	// ID로 회원정보 조회
	public Member selectById(SqlSession session, String id);
	// 회원가입
	public int insertMember(SqlSession session, Member member);
	public int updateMember(SqlSessionTemplate session, Member member);
	
	// select 문 조회 -> 조회 결과 리턴해주고,
	// insert, delete, update -> 숫자를 리턴해줌 -> 1 = 성공 , 0 = 실패

}
