package com.so.hard.member.model.service;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.so.hard.member.model.dao.MemberDAO;
import com.so.hard.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO dao;

	@Autowired
	private SqlSessionTemplate session;

	@Autowired
	private BCryptPasswordEncoder encoder;
	// DB에서 Data Member -> idNo / id / pwd
	// 로그인을 하면 비밀번호 확인 필요
	// pwd -> 암호화 DB에 저장되는 비밀번호는 모두 암호화가 되어있다!!
	
	@Override
	public Member login(Map<String, String> map) {
		Member member = dao.selectById(session, map.get("id"));
		
		if (member == null) {
			return null;
		}
		String inputPwd = map.get("pwd");

		String pwd = member.getPassword();

		boolean match = encoder.matches(inputPwd, pwd);
		
		if (match == false) {
			return null;
		}

		return member;
	}
	
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int join(Member member) {
		// member id / pwd
		member.setPassword(encoder.encode(member.getPassword()));
		
		int result = dao.insertMember(session, member);// DB insert
		return result;
	}


	@Override
	public Member findId(String id) {
		return dao.selectById(session, id);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean modifyMember(Member member) {
		member.setPassword(encoder.encode(member.getPassword()));
		int result = dao.updateMember(session, member);
		if (result > 0 ) {
			return true;
		}
		return false;
	}

}
