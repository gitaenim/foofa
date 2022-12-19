package com.green.nowon.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.dto.GoodsListDTO;
import com.green.nowon.domain.entity.category.CategoryEntity;
import com.green.nowon.domain.entity.category.CategoryEntityRepository;
import com.green.nowon.domain.entity.category.CategoryItemEntityRepository;
import com.green.nowon.domain.entity.goods.GoodsEntityRepository;
import com.green.nowon.service.GoodsService;

@Service
public class GoodsServiceprocess implements GoodsService {

	@Autowired
	private GoodsEntityRepository repo;
	@Autowired
	CategoryItemEntityRepository cateItemRepo;
	@Autowired
	GoodsEntityRepository imgRepo;
	@Autowired
	CategoryEntityRepository cateRepo;

	@Override
	public void findAll(Model model) {
		List<GoodsListDTO> result=repo.findAll().stream()
				.map(GoodsListDTO::new).collect(Collectors.toList());
		
		model.addAttribute("list", result);
	}

	@Override
	public void goodsOfCategory(long cateNo, Model model) {
		//카테고리에 해당하는 상품들모두
		CategoryEntity ca=cateRepo.findById(cateNo).get();
		System.out.println("현재카테고리:"+ca.getName());
		CategoryEntity su=ca.getParent();
		if(su!=null) {
			System.out.println("상위카테고리:"+su.getName());
			su=su.getParent();
			if(su!=null) {
				System.out.println("상위카테고리:"+su.getName());
				su=su.getParent();
				if(su!=null) {
					System.out.println("상위카테고리:"+su.getName());
					su=su.getParent();
				}
			}
		};
		
		
		model.addAttribute("cate", ca);
		model.addAttribute("list", cateItemRepo.findAllByCategoryNo(cateNo)
				.stream()
				.map(GoodsListDTO::new)
				.collect(Collectors.toList()));
	}
}
