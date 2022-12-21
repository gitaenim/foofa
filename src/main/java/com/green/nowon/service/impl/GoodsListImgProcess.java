package com.green.nowon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.entity.goods.GoodsImgRepository;
import com.green.nowon.service.goodsservice.GoodsListImgService;


@Service
public class GoodsListImgProcess implements GoodsListImgService {

	@Autowired
	GoodsImgRepository repo;

	@Override
	public void findAll(Model model) {
		repo.findAll();
		
	}
}
