package com.so.hard.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.so.hard.board.model.vo.Board;
import com.so.hard.board.model.vo.Reply;
import com.so.hard.common.util.PageInfo;

public interface BoardDAO {
	// 기능
	// 1. 목록 조회
	// 1-1. 글 갯수 조회
	// 2. 검색 목록 조회
	// 2-1. paging 기능
	// 3. 글 조회
	// 4. 작성
	// 5. 수정
	// 6. 삭제
	// 7. reply 작성
	// 8. reply 수정
	// 9. reply 삭제
	public int selectBoardCnt(SqlSession session, Map<String, String> map);

	public List<Board> selectBoard(SqlSession session, PageInfo pageInfo, Map<String, String> map);

	public Board selectBoardDetail(SqlSession session, int bNo);

	public int insertBoard(SqlSession session, Board board);

	public int updateBoard(SqlSession session, Board board);

	public int deleteBoard(SqlSession session, int bNo);

	public int insertReply(SqlSession session, Reply reply);

	public int updateReply(SqlSession session, Reply reply);

	public int deleteReply(SqlSession session, int rNo);

}
