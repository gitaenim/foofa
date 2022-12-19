package com.green.nowon.domain.entity.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.green.nowon.domain.entity.cart.CartEntity;
import com.green.nowon.domain.entity.delivery.DeliveryEntity;
import com.green.nowon.domain.entity.member.MemberEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@SequenceGenerator(name = "gen_o",sequenceName = "seq_o",allocationSize = 1,initialValue = 1)
@Table(name = "foo_order")
@Entity
public class OrderEntity {

	@Id
	@GeneratedValue(generator = "gen_o",strategy = GenerationType.SEQUENCE)
	private long ono;

	
	@ManyToOne
	@JoinColumn(name = "dno")
	private DeliveryEntity dno;
	
	@ManyToOne
	@JoinColumn(name = "mno")
	private MemberEntity mno;
	
	@OneToOne
	@JoinColumn(name = "cno")
	private CartEntity cno;
	
	@Column(nullable = false)
	private String status;
	
	@Column(nullable = true)
	private String memo;
}
