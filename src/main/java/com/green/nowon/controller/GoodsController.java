package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.green.nowon.service.goodsservice.GoodsService;
import com.green.nowon.service.impl.GoodsListImgService;

@Controller
public class GoodsController {
	
	@Autowired
	GoodsService service;
	
	@Autowired
	GoodsListImgService imgService;
	
	@GetMapping("/list")
	public String list(Model model){
		service.findAll(model);
		imgService.findAll(model);
		return "goods/list";
	}
	
//	@GetMapping("/common/category/{no}/goods")
//	public String goodsOfCategory(@PathVariable long no, Model model) {
//		service.goodsOfCategory(no, model);
//		return "goods/category-list";
//	}
}
