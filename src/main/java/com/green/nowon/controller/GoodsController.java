package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.green.nowon.domain.entity.goods.GoodsListImg;
import com.green.nowon.service.GoodsListImgService;
import com.green.nowon.service.GoodsService;

@Controller
public class GoodsController {

	@Autowired
	GoodsService service;
	@Autowired
	GoodsListImgService listService;
	
	@GetMapping("/list")
	public String list(Model model){
		
		service.findAll(model);
		listService.findAll(model);
		return "goods/list";
	}
}
