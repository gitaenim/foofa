package com.green.nowon.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.green.nowon.domain.dto.GoodsInsertDTO;
import com.green.nowon.service.goodsservice.GoodsService;

@org.springframework.stereotype.Controller
public class AdminController {
	
	@Autowired
	private GoodsService service;
	
	@GetMapping("/admin")
	public String admin() {
		
		return "admin/admin";
	}
	
	@GetMapping("/admin/authority")
	public String authority() {
		return "admin/authority";
	}
	

	@GetMapping("/admin/delivery-status")
	public String deliveryStatus() {
		
		return "admin/delivery-status";
	}
	
	
	@GetMapping("/admin/goods")
	public String GoodsReg() {
		return "admin/goods/goods-reg";
	}
	
	@PostMapping("/admin/goods/reg")
	public String GoodsReg(GoodsInsertDTO dto) {
		service.save(dto);
		return "admin/goods/goods-reg";
	}
	
	@GetMapping("/admin/board")
	public String BoardList() {
		return "admin/board/faq-list";
	}
	
	@ResponseBody
	@PostMapping("/admin/temp-up")
	public Map<String, String> tempUp(MultipartFile gimg){
		return service.fileTempUp(gimg);
	}

}