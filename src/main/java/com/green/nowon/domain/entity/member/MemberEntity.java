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
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "foo_member")
@Entity
public class MemberEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long mno;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable = false)
	private String pass;
	@Column(nullable = false)
	private String name;
	
	
	@Builder.Default
	@CollectionTable(name = "foo_member_role")
	@Enumerated(EnumType.STRING)
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<Role> roles=new HashSet<>();
	public MemberEntity addRole(Role role) {
		roles.add(role);
		return this;
	}
}
