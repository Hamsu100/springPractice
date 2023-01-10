package com.so.hard.member.contoller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 * RequestMapping("주소")
 * ContextPath/주소/
 */
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.so.hard.member.model.service.MemberService;
import com.so.hard.member.model.vo.Member;

/*
 * Web -> 요청 받고 응답을 해줌 -> 사용자가 로그인 클릭을 함. 요청안에 담긴 파라미터들을 가지고 응답을 해줌.
 * 요청 실행 후 없어짐.
 * 서버 / 브라우저
 * 
 * 서버 : 컨텍스트 쓰면 안됨 -> 서버 메모리를 처먹어서 서버 리스타트를 많이 해야됨. 불안정해짐.
 * 브라우저 : 세션
 * 
 */
// Http 통신

// Web server 
@RequestMapping("/member")
@Controller
public class MemberController {
	@Autowired // 컴포넌트 매핑
	private MemberService ms;

	// url -> context/member/login

	@GetMapping("/login.do")
	public String moveLogin() {
		return "member/login";
	}

	@PostMapping("/login.do")
	public String login(@RequestParam String id, @RequestParam String pwd, HttpSession session, Model model) {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pwd", pwd);
		System.out.println(id + " " + pwd);
		Member loginMember = ms.login(map);

		if (loginMember == null) {
			System.out.println("login 실패");
			model.addAttribute("msg", "login 실패");
			model.addAttribute("location", "/");
			return "common/msg";
		}

		session.setAttribute("loginMember", loginMember);

		model.addAttribute("msg", "login 성공");
		model.addAttribute("location", "/");
//		resp -> 유효 하지 않음.
		return "common/msg";
	}

	@GetMapping("/join.do")
	public String moveJoin() {
		return "member/join";
	}

	@PostMapping("/join.do") // insert
	public String join(@RequestParam Map<String, String> map, Model model) {
		// {key : value}

		// {front- name property : value property}
		Member m = new Member();

		m.setId(map.get("id"));
		m.setPassword(map.get("pwd"));

		int result = ms.join(m);

		if (result > 0) {
			model.addAttribute("msg", "join 성공");
			model.addAttribute("location", "/");
			return "common/msg";
		} else {
			model.addAttribute("msg", "join 실패");
			model.addAttribute("location", "/");
			return "common/msg";
		}
	}

	@GetMapping("/dupId") // http 통신 TCP IP -> 야 나 정보 달라고 할건데 지금 있니? -> 서버 : ㅇㅇ 나있음 -> 아 그러면 나 이런 정보좀 줘 -> 서버 : ㅇㅋㅇㅋ
	public ResponseEntity<String> dupId(@RequestParam String id) {
		String flag ="true";
		Member result = ms.findId(id);
		if (result == null) {
			flag = "false";
		}
		// Rest API -> Data Transfer / Server -> client /SSR : Server side rendering -> data? client 기본 body json format
		// 일반 객체 -> {"":""}
		return new ResponseEntity<String>(flag, HttpStatus.OK); // {"flag" : "true"} // 통신 성공했어! 
	}
	
	@GetMapping("/logout.do")
	public String logout(HttpSession session, Model model) {
//		session.setAttribute("loginMember", null); // session 삭제 1
		session.invalidate(); // session 삭제 2
		model.addAttribute("msg","log out");
		model.addAttribute("location", "/");
		return "common/msg";
	}
	
	HttpServletRequest req; // http 요청 get method ~ / parameter ~ / url
	HttpServletResponse resp; // http 응답 html
	
	@GetMapping("/update.do")
	public String moveUpdate() {
		return "member/update";
	}
	
	@PostMapping("/update.do")
	public String updateMember(Model model, @RequestParam String pwd, @SessionAttribute Member loginMember, HttpSession session) {
		// pwd 변경 -> 로그인 된 상태인지 확인
		
//		Member lm =(Member)session.getAttribute("loginMember");
		
		if (loginMember == null) {
			model.addAttribute("msg","잘못된 요청입니다.");
			model.addAttribute("location","/");
			return "common/msg";
		}
		
		loginMember.setPassword(pwd);
		
		boolean result = ms.modifyMember(loginMember);
		
		if (result) {
			model.addAttribute("msg","변경 성공");
			model.addAttribute("location","/");
			return "common/msg";
		} else {
			model.addAttribute("msg","변경 실패");
			model.addAttribute("location","/");
			return "common/msg";
		}
		
	}
	

}
