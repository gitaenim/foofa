package com.green.nowon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.green.nowon.domain.entity.board.BoardEntityRepository;
import com.green.nowon.domain.entity.member.MemberEntityRepository;

@SpringBootTest
class FoofaApplicationTests {

	@Autowired
	BoardEntityRepository bRepository;
	
	@Autowired
	MemberEntityRepository mRepository;
	


}
