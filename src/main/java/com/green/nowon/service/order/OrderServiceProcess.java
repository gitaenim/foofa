package com.green.nowon.service.order;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.dto.order.DeliveryInfoDTO;
import com.green.nowon.domain.dto.order.OrderGoodsDTO;
import com.green.nowon.domain.dto.order.OrderGoodsListDTO;
import com.green.nowon.domain.entity.delivery.DeliveryEntityRepository;
import com.green.nowon.domain.entity.goods.GoodsEntityRepository;
import com.green.nowon.domain.entity.member.MemberEntityRepository;

@Service
public class OrderServiceProcess implements OrderService {

	@Autowired
	private DeliveryEntityRepository dRepo;
	@Autowired
	private MemberEntityRepository mRepo;
	@Autowired
	private GoodsEntityRepository gRepo;
	
	@Transactional
	@Override
	public void orderGoods(OrderGoodsDTO dto, Model model) {
		model.addAttribute("list",gRepo.findById(dto.getGoodsNo())
				.map(OrderGoodsListDTO::new).get().quantity(dto.getOrderQuantity()));
	}
	
	@Override
	public void deliveryInfoSave(DeliveryInfoDTO dto, String email) {
		dRepo.save(dto.toEntity())
			.base(dRepo.countByMemberEmail(email)==0?true:false)//배송정보가 없으면 base=true
			.member(mRepo.findByEmail(email).orElseThrow());
	}

	

}
