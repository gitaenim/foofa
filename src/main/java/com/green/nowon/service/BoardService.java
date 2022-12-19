package com.green.nowon.service;

import org.springframework.web.servlet.ModelAndView;

public interface BoardService {

	void listForAjax(ModelAndView mv, String division, int page);

}
