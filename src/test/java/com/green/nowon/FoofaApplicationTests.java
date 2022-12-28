package com.green.nowon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.green.nowon.domain.entity.board.BoardEntityRepository;
import com.green.nowon.domain.entity.board.faq.FaqEntity;
import com.green.nowon.domain.entity.board.faq.FaqEntityRepository;
import com.green.nowon.domain.entity.member.MemberEntityRepository;

@SpringBootTest
class FoofaApplicationTests {

	@Autowired
	BoardEntityRepository bRepo;
	
	@Autowired
	MemberEntityRepository mRepo;
	
	@Autowired
	FaqEntityRepository fRepo;
	

	//@Test
	void faq() {
		fRepo.save(
				FaqEntity.builder()
				.division("delivery")
				.question("배송지를 변경하고 싶어요")
				.answer("상품이 이미 발송된 경우 배송지 변경이 어렵습니다. 반품 신청 후 재주문해주세요.")
				.build() //엔티티생성
				
				);
	}

}
