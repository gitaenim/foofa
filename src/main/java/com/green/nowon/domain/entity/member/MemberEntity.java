package com.green.nowon.domain.entity.member;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@SequenceGenerator(name = "gen_mem", initialValue = 1, allocationSize = 1 ,sequenceName = "seq_mem")
@Table(name = "member")
@Entity
public class MemberEntity {
	
	@Id
	@GeneratedValue(generator = "gen_mem",strategy = GenerationType.SEQUENCE)
	private long mno;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable = false)
	private String pass;
	@Column(nullable = false)
	private String name;
	
	@Builder.Default
	@CollectionTable(name = "member_role")
	@Enumerated(EnumType.STRING)
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<Role> roles=new HashSet<>();
	
	public MemberEntity addRole(Role role) {
		roles.add(role);
		return this;
	}
}
