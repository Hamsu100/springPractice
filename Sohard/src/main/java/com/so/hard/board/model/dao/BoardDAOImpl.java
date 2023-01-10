package com.so.hard.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.so.hard.board.model.vo.Board;
import com.so.hard.board.model.vo.Reply;
import com.so.hard.common.util.PageInfo;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Override
	public int selectBoardCnt(SqlSession session, Map<String, String> map) {
		return session.selectOne("", map);
	}

	@Override
	public List<Board> selectBoard(SqlSession session, PageInfo pageInfo, Map<String, String> map) {
		map.put("start", "" + pageInfo.getStartList()); // 100개 리스트 10개씩 10페이지 1 1~10, 2 11~20...
		map.put("end", "" + pageInfo.getEndList());
		return session.selectList("", map);
	}

	@Override
	public Board selectBoardDetail(SqlSession session, int bNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertBoard(SqlSession session, Board board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoard(SqlSession session, Board board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(SqlSession session, int bNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertReply(SqlSession session, Reply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateReply(SqlSession session, Reply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteReply(SqlSession session, int rNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
