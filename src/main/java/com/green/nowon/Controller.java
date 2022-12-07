package com.green.nowon;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
	
	@GetMapping("admin")
	public String admin() {
		
		return "/admin/admin";
		
	}

}
