package com.green.nowon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.green.nowon.domain.entity.goods.GoodsListImgRepository;
import com.green.nowon.service.GoodsListImgService;

public class GoodsListImgProcess implements GoodsListImgService {

	@Autowired
	GoodsListImgRepository repo;

	@Override
	public void findAll(Model model) {
		repo.findAll();
		
	}
}
