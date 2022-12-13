package com.green.nowon.domain.entity.goods;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@DynamicUpdate
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "sale")
@Entity
public class SaleEntity {
	
	@Column(nullable = false)
	private String startDate;
	
	@Column(nullable = false)
	private String endDate;
	
	@Column(nullable = false)
	private int saleRate;
	
	@Column(nullable = false)
	private int gno;
	
}
