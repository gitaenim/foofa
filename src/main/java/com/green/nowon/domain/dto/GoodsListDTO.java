package com.green.nowon.domain.dto;

import com.green.nowon.domain.entity.category.CategoryItemEntity;

import com.green.nowon.domain.entity.goods.GoodsEntity;

import lombok.Data;
import lombok.Getter;

@Data
public class GoodsListDTO {
	
	private long no;
	private String title;
	private int price;

	private int stock;
	
	//이미지 대표이미지
	private String defImgUrl;

	public GoodsListDTO(GoodsEntity e) {
		this.no = e.getGoodsNo();
    
	private String content;
	//이미지테이블에 저장되어있음
	private String imgUrl;

	public GoodsListDTO(GoodsEntity e) {
		this.no =e.getGoodsNo();

		this.title = e.getTitle();
		this.price = e.getPrice();
		this.stock = e.getStock();
		this.defImgUrl = e.defImg().getUrl()+e.defImg().getNewName();
	}
	public GoodsListDTO(CategoryItemEntity cie) {
		this(cie.getItem());
	}
	
		

}
