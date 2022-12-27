package com.green.nowon.domain.entity.delivery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "foo_delivery")
@Entity
public class DeliveryEntity {
//
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long dno;
	
	@Column(nullable = false)
	private int zip;
	@Column(nullable = false)
	private String addr1;
	@Column()
	private String addr2;
	@Column(nullable = false)
	private String receiver;
	@Column(nullable = false)
	private String phone;
	
	
}