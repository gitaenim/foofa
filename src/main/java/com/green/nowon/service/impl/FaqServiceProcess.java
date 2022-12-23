package com.green.nowon.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.green.nowon.domain.dto.board.PageDTO;
import com.green.nowon.domain.dto.board.faq.FaqDTO;
import com.green.nowon.domain.entity.board.faq.FaqEntity;
import com.green.nowon.domain.entity.board.faq.FaqEntityRepository;
import com.green.nowon.service.FaqService;

@Service
public class FaqServiceProcess implements FaqService {
	
	@Autowired
	private FaqEntityRepository fRepo;
	
	@Override
	public void listForAjax(ModelAndView mv, String division, int page) {

		int rowTotal=fRepo.countAllByDivision(division); //rowTotal 총 게시글 수
		
		//int limit=10; //한 페이지에 표현할 row 개수
		//int offset = limit * (page-1); //첫번째 결과부터 건너뛰는 개수
		//RowBounds rowBounds = new RowBounds(offset, limit);
		//offset만큼 건너뛰고 limit개수를 읽어옴
		//리스트정보
		int size=10;
		Pageable pa= PageRequest.of(page-1, size, Sort.by(Direction.ASC, "question"));
		Page<FaqEntity> result = fRepo.findAllByDivision(division, pa);
		//페이지정보
		//PageDTO pageInfo = PageDTO.getInstance(page, rowTotal, limit, 8);
		mv.addObject("list",result.getContent().stream()
				.map(FaqDTO::new)
				.collect(Collectors.toList()));
		//mv.addObject("pi",pageInfo);
		
	}
	
}
