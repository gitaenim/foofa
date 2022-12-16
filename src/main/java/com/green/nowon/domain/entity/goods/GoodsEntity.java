package com.green.nowon.domain.entity.goods;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
public class GoodsEntity extends BaseDateEntity {
	@Id
	@GeneratedValue(generator = "g_s_goods", strategy = GenerationType.SEQUENCE)
	@Column(name = "gno")
	private long goodsNo;
	
	@Column(unique = true, nullable = false) //unique not null
	private String title;

	@Column(nullable = false)
	private int price;
	@Column
	private int stock;
	
	@Lob
	private String content;
	
	
	/*
	//1:M -- 상품:Category(enum)
	@Enumerated(EnumType.STRING) //따로 지정하지 않으면 숫자로 저장됨(ORDINAL)
	@Builder.Default //new Hashset<>(); 빌더 적용시 default로 사용
	@CollectionTable(name = "category")
	@ElementCollection(fetch = FetchType.EAGER) //테이블로 사용할 수 있음 //EAGER : Category 즉시로딩
	private Set<Category> category = new HashSet<>();
	*/
	
	/*
	//편의메서드 적용하면 Set콜렉션 사용이 편리
	public GoodsEntity addCategory(Category category) {
		category.add(category);
		return this;
	}
	*/
	
	
	
}
