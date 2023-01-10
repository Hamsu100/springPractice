package com.so.hard.board.model.service;

import java.util.List;
import java.util.Map;

import com.so.hard.board.model.vo.Board;
import com.so.hard.board.model.vo.Reply;
import com.so.hard.common.util.PageInfo;

public interface BoardService {
	// Board 관련
	public int getBoardCnt(Map<String, String> map);

	public List<Board> getBoardList(Map<String, String> map, PageInfo pageInfo);

	public Board getBoard(int bNo);
	
	public int addBoard(Board board);
	
	public int modifyBoard(Board board);
	
	public int delete(int bNo);
	
	public String saveFile(String filePath, String fileName);
	
	public void deleteFile();
	
	// Reply 관련
	
	public int addReply(Reply reply);
	
	public int modifyReply(Reply reply);
	
	public int deleteReply(int rNo);
}
