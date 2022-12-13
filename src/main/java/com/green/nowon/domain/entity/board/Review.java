package com.green.nowon.domain.entity.board;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.green.nowon.domain.entity.BaseDateEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@SequenceGenerator(name = "gen_seq_foo_review",
		sequenceName = "seq_re" ,initialValue = 1,allocationSize = 1)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "foo_review")
@Entity
public class Review extends BaseDateEntity {
	
	@Id
	@GeneratedValue(generator = "gen_seq_foo_review")
	private long rno;
	@Column(nullable = false)
	private int rating;
	@Column(nullable = false)
	private String content;

}

