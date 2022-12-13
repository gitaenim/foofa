package com.green.nowon.entity.cart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@SequenceGenerator(name = "gen_c",sequenceName = "seq_c",allocationSize = 1,initialValue = 1)
@Table(name = "cart")
@Entity
public class CartEntity {

	@Id
	@GeneratedValue(generator = "gen_c",strategy = GenerationType.SEQUENCE)
	private long cno;
	
	@OneToOne
	@JoinColumn(name = "mno")
	private long mno;
	
}
