package com.green.nowon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.green.nowon.domain.entity.board.BoardEntityRepository;
import com.green.nowon.domain.entity.member.MemberEntity;
import com.green.nowon.domain.entity.member.MemberEntityRepository;
import com.green.nowon.domain.entity.member.Role;


@SpringBootTest
class FoofaApplicationTests {

	@Autowired
	BoardEntityRepository bRepository;
	
	@Autowired
	MemberEntityRepository mRepository;
	
	@Autowired
	PasswordEncoder pe;
	
	@Test
	void 어드민계정() {
		
		mRepository.save(
				MemberEntity.builder()
				.email("admin@test.com")
				.pass(pe.encode("1234"))
				.name("관리자")
				.build()//엔티티생성
				.addRole(Role.USER)
				.addRole(Role.ADMIN)
				);
	}

}
