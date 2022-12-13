package com.green.nowon.domain.entity.board;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.green.nowon.domain.entity.BaseDateEntity;
import com.green.nowon.domain.entity.member.MemberEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@SequenceGenerator(name = "gen_foo_borad" ,
		sequenceName = "seq_foo_borad",initialValue = 1,allocationSize = 1)
@Table(name = "foo_board")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Board extends BaseDateEntity{
	
	@GeneratedValue(generator = "gen_foo_borad" , strategy = GenerationType.SEQUENCE)
	@Id
	private long bno;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String content;
	
	private long readCount;
	
	
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "mno")
	 private MemberEntity member;
	 
	
}
