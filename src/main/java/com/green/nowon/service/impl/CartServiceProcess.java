package com.green.nowon.service.impl;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.green.nowon.domain.dto.CartItemListDTO;
import com.green.nowon.domain.dto.CartItemSaveDTO;
import com.green.nowon.domain.entity.cart.CartEntity;
import com.green.nowon.domain.entity.cart.CartEntityRepository;
import com.green.nowon.domain.entity.cart.CartItemEntity;
import com.green.nowon.domain.entity.cart.CartItemEntityRepository;
import com.green.nowon.domain.entity.goods.GoodsEntityRepository;
import com.green.nowon.domain.entity.member.MemberEntityRepository;
import com.green.nowon.service.CartService;



public class CartServiceProcess implements CartService {
	
	@Autowired
	private CartEntityRepository cartRepo;
	
	private MemberEntityRepository memRepository;
	
	private CartItemEntityRepository cartItemRepo;
	
	private GoodsEntityRepository goodsRepo;
	
	@Override
	public void cartItems(Model model, String email) {
		model.addAttribute("list", cartItemRepo.findByCnoMno(email)
				.stream()
				.map(CartItemListDTO::new)
				.collect(Collectors.toList()));
		
	}
	
	@Transactional
	@Override
	public void save(CartItemSaveDTO dto, String email) {
		
		CartEntity cart= (cartRepo.findByMnoEmail(email)
				.orElseGet(()->cartRepo.save(CartEntity.builder()
						.mno(memRepository.findByEmail(email).orElseThrow())
						.build())));
		
		cartItemRepo.findByCnoAndGno(cart.getCno(), dto.getItemNo()).ifPresentOrElse(
				//존재하면 구매수량 증가
				e->e.updateQuantity(dto.getQuantity()),
				//존재하지 않으면 저장
				()->cartItemRepo.save(CartItemEntity.builder()
						.cno(cart)
						.gno(goodsRepo.findById(dto.getItemNo()).get())
						.count(dto.getQuantity())
						.build())
		);

	}

}
