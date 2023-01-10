package com.so.hard.member.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.so.hard.member.model.vo.Member;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Override
	public Member selectById(SqlSession session, String id) {
		return session.selectOne("memberMapper.selectById", id);
	}

	@Override
	public int insertMember(SqlSession session, Member member) {
		// id / pwd / 최근에 입력된 값을 조회해 와서 +1해주고 집어넣음.
		if (session.selectOne("memberMapper.selectLast") != null) {
			member.setIdNo((int)session.selectOne("memberMapper.selectLast") + 1);
		} else {
			member.setIdNo(1);
		}
		return session.insert("memberMapper.insertMember", member);
	}

	@Override
	public int updateMember(SqlSessionTemplate session, Member member) {
		return session.update("memberMapper.updateMember", member);
	}

}
