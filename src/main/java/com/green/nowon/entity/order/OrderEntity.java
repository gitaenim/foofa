package com.green.nowon.entity.order;

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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@SequenceGenerator(name = "gen_o",sequenceName = "seq_o",allocationSize = 1,initialValue = 1)
@Table(name = "order")
@Entity
public class OrderEntity {

	@Id
	@GeneratedValue(generator = "gen_o",strategy = GenerationType.SEQUENCE)
	private long ono;
	
	@ManyToOne
	@JoinColumn(name = "dno")
	private long dno;
	
	@ManyToOne
	@JoinColumn(name = "mno")
	private long mno;
	
	@OneToOne
	@JoinColumn(name = "cno")
	private long cno;
	
	@Column(nullable = false)
	private String status;
	
	private String memo;
}
