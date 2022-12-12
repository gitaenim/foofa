package com.green.nowon.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class AdminController {
	
	@GetMapping("admin")
	public String admin() {
		
		return "/admin/admin";
	}
	
	@GetMapping("admin/authority")
	public String authority() {
		
		return "/admin/authority";
	}
	

}