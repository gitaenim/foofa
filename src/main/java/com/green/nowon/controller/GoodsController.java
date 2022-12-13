package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoodsController {
	
	@GetMapping("/goods/1")
	public String detail() {
		return "goods/detail";
	}
	
}
