package com.green.nowon.domain.entity.goods;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
//@DynamicUpdate
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "gen_seq_goods_img",
		sequenceName = "seq_img",initialValue = 1,allocationSize = 1)
@Table(name = "goods_img")
@Entity
public class GoodsImg {
	
	@Id
	@GeneratedValue(generator = "gen_seq_goods_img", strategy = GenerationType.SEQUENCE)
	private long ino;
	@Column(nullable = false)
	private String url;
	@Column(nullable = false)
	private String orgName;
	@Column(nullable = false)
	private String newName;
	
	private boolean def;
	
	@JoinColumn
	@ManyToOne
	private GoodsEntity goods;
	
}
