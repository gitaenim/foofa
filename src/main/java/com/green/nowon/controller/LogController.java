package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.nowon.domain.dto.MemberDTO;
import com.green.nowon.service.LogService;

@Controller
public class LogController {
	
	@Autowired
	private LogService service;
	
	@GetMapping("/login")
	public String login() {
		return "log/login";
	}

	@GetMapping("/signup")
	public String signup() {
		return "log/signup";
	}
	
	@PostMapping("/signup")
	public String signup(MemberDTO dto) {
		service.save(dto);
		return "redirect:/login";
	}
	
	@GetMapping("/cart")
	public String cart() {
		return "member/cart";
	}
	
	
	@ResponseBody
	@GetMapping("/member/login-check")
	public boolean loginCheck(Authentication auth) {
		System.out.println(auth);
		//로그인했을때는 인증정보확인가능
		//비로그인시는 null
		System.out.println("인증 : "+auth);
		return auth==null? false:true;
	}
	

}
