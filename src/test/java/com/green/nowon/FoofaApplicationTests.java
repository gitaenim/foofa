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
				.division("cancel")
				.question("교환(반품) 어떻게 신청하나요?")
				.answer("교환(반품) 사유+문제가 발생한 부분을 확인할 수 있는 사진과 함께 고객센터로 문의 바랍니다.")
				.build() //엔티티생성
				
				);
	}

}
