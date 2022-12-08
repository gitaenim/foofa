package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogController {
	
	@GetMapping("/login")
	public String login() {
		return "log/login";
	}
	
	@PostMapping("/signup")
	public String signup() {
		return "log/signup";
	}
}
