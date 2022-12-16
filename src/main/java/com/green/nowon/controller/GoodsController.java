package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoodsController {

	//@Autowired
	//private GoodsService service;
	//GoodsService service = new GoodsServiceProcess();
	
	@GetMapping("/admin/goods")
	public String goods() {
		return "goods/reg";
	}

	@GetMapping("/goods/1")
	public String detail() {
		return "goods/detail";
	}
	
	@GetMapping("/goods/detail/review")
	public String category() {
		return "goods/review";
	}

}