package com.green.nowon.entity.cart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "gen_ci",sequenceName = "seq_ci",allocationSize = 1,initialValue = 1)
@Table(name = "cartItem")
@Entity
public class CartItemEntity {

	@Id
	@GeneratedValue(generator = "gen_ci",strategy = GenerationType.SEQUENCE)
	private long cino;
	
	@ManyToOne
	@JoinColumn(name = "cno")
	private long cno;
	
	@ManyToOne
	@JoinColumn(name = "gno")
	private long gno;
	
	@Column(nullable = false)
	private int count;
	
	@Column(nullable = false)
	private boolean selected;
}
