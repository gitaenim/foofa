package com.green.nowon.domain.entity.goods;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.green.nowon.domain.entity.BaseDateEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@DynamicUpdate
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@SequenceGenerator(name = "g_s_goods",
		sequenceName = "s_goods", initialValue = 1, allocationSize = 1)
@Table(name = "goods")
@Entity
public class GoodsEntity extends BaseDateEntity{
	@Id
	@GeneratedValue(generator = "g_s_goods", strategy = GenerationType.SEQUENCE)
	@Column(name = "gno")
	private long goodsNo;
	
	@Column(unique = true, nullable = false) //unique not null
	private String title;
	
	@Column(nullable = false)
	private String content;
	
	@Column(nullable = false)
	private int price;
	
	@Column
	private int stock;
	
	@Builder.Default
	@OneToMany(mappedBy = "goods")
	private List<GoodsImg> imgs=new ArrayList<>();
	
	public GoodsImg defImg() {
		for(GoodsImg img:imgs) {
			if(img.isDef()) return img;
				
		}
		return imgs.get(0);//만약에 대표이지미지 없으면 첫번째이미지로
	}

}