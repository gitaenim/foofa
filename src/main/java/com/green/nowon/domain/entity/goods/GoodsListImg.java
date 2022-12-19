package com.green.nowon.domain.entity.goods;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.ui.Model;

import com.green.nowon.domain.entity.BaseDateEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class GoodsListImg extends BaseDateEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;
	private String orgName;
	private String newName;
	private String url;
	private boolean defImg;
	
	@JoinColumn//item_no
	@ManyToOne
	private GoodsEntity goods;

}
