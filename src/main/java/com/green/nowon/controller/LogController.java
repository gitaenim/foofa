package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.nowon.domain.dto.MemberDTO;
import com.green.nowon.service.LogService;
import com.green.nowon.service.MemberService;

@Controller
public class LogController {
	
	@Autowired
	private LogService service;
	
	@Autowired
	private MemberService memservice;
	
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
	
	@ResponseBody
	@GetMapping("/login-check")
	public boolean loginCheck(Authentication auth) {
		//로그인했을때는 인증정보확인가능
		//비로그인시 는 null
		return auth==null? false:true;
	}
	
	@DeleteMapping("/delete/{mno}")
	public String delete(@PathVariable long mno) {
		memservice.deleteMno(mno);
		return "redirect:/admin/authority";
	}

}
