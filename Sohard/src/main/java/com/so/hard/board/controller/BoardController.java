package com.so.hard.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.so.hard.board.model.service.BoardService;
import com.so.hard.board.model.vo.Board;
import com.so.hard.common.util.PageInfo;

@Controller
public class BoardController {

	@Autowired
	private BoardService bs;
	
	@GetMapping("/list.do")
	public String getBoardList(@RequestParam(required = false) Map<String, String> map, Model model) {
		// 1. 전체 리스트 갯수
		// 2. 검색어 있으면 검색어 매핑
		// 3. 게시판 리스트 가져오기 + Paging 처리
		// Connect With Polarion
		
		int page = 1;
		
		if (map.containsKey("page")) {
			page = Integer.parseInt(map.get("page"));
		}
		
		// map : searchType, searchValue
		PageInfo pageInfo = new PageInfo(page,10,bs.getBoardCnt(map),10);
		
		List<Board> list = bs.getBoardList(map, pageInfo);
		
		model.addAttribute("bList", list);
		
		return "board/list";
	}
}
