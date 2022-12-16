package com.green.nowon.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.dto.GoodsListDTO;
import com.green.nowon.domain.entity.goods.GoodsEntityRepository;
import com.green.nowon.service.GoodsService;

@Service
public class GoodsServiceprocess implements GoodsService {

	@Autowired
	private GoodsEntityRepository repo;

	@Override
	public void findAll(Model model) {
		List<GoodsListDTO> result=repo.findAll().stream()
				.map(GoodsListDTO::new).collect(Collectors.toList());
		
		model.addAttribute("list", result);
	}
}
