package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.green.nowon.service.GoodsListImgService;
import com.green.nowon.service.goodsservice.GoodsService;

@Controller
public class GoodsController {

	@Autowired
	GoodsService service;
	
	@GetMapping("/list")
	public String list(Model model){
		service.list(model);
		return "goods/list";
	}

}
