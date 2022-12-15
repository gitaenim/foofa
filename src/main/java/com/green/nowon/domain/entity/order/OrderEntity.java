package com.green.nowon.domain.entity.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@SequenceGenerator(name = "gen_o",sequenceName = "seq_o",allocationSize = 1,initialValue = 1)
@Table(name = "foo_order")
@Entity
public class OrderEntity {

	@Id
	@GeneratedValue(generator = "gen_o",strategy = GenerationType.SEQUENCE)
	private long ono;
	
	
	@Column(nullable = false)
	private String status;
	private String memo;
}
