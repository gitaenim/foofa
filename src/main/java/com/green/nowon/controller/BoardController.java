package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.green.nowon.service.BoardService;
import com.green.nowon.service.impl.BoardServiceProcess;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/board")
	public String boardlist() {
		return "board/page/faq";
	}
	
	@GetMapping("/board/oneonone")
	public String boardlist2() {
		return "board/page/fone";
	}
	
	
}
