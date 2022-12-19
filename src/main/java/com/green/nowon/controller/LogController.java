package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
		return "redirect:/log/login";
	}
	
	@GetMapping("/cart")
	public String cart() {
		return "member/cart";
	}

}
