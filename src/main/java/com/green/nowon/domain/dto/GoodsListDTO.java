package com.green.nowon.domain.dto;

import com.green.nowon.domain.entity.goods.GoodsEntity;

import lombok.Getter;


@Getter//페이지에서 데이터추출하기위해
public class GoodsListDTO {
	
	private long no;
	private String title;
	private int price;
	private String content;
	//이미지테이블에 저장되어있음
	private String imgUrl;

	public GoodsListDTO(GoodsEntity e) {
		this.no =e.getGoodsNo();
		this.title = e.getTitle();
		this.price = e.getPrice();
		this.content=e.getContent();
		
	}
	
		

}
