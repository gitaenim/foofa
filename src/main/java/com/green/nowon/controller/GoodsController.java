package com.green.nowon.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.green.nowon.service.GoodsService;

@Controller
public class GoodsController {
	
	//GoodsService service = new GoodsServiceProcess();
	@Autowired
	private GoodsService service;
	
	@GetMapping("/admin/goods")
	public String goods() {
		return "goods/reg";
	}
	
	//@ResponseBody //응답데이터를 json타입으로 리턴합니다.
	@PostMapping("/admin/temp-upload")
	public @ResponseBody Map<String, String> tempUpload(MultipartFile gimg) {
		//System.out.println(" >>>>> "+gimg.getOriginalFilename());
		return service.fileTempUpload(gimg);
	}
		
	@GetMapping("/goods/1")
	public String detail() {
		return "goods/detail";
	}
	
}
