package com.green.nowon.domain.entity.order;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.green.nowon.domain.entity.BaseDateEntity;
import com.green.nowon.domain.entity.member.MemberEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "foo_order")
@Entity
public class OrderEntity extends BaseDateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ono;//주문번호
	
	private LocalDateTime orderDate; //주문한 날짜
	
	@JoinColumn//member_mno
	@ManyToOne
	private MemberEntity member;//주문자 정보
	
	
}