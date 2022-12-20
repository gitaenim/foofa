package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.green.nowon.domain.entity.goods.GoodsListImg;
import com.green.nowon.service.GoodsListImgService;
import com.green.nowon.service.GoodsService;

@Controller
public class GoodsController {

	@Autowired
	GoodsService service;
	
	@GetMapping("/list")
	public String list(Model model){
		service.list(model);
		return "goods/list";
	}
	
	@GetMapping("/common/category/{no}/goods")
	public String goodsOfCategory(@PathVariable long no, Model model) {
		service.goodsOfCategory(no, model);
		return "goods/category-list";
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
