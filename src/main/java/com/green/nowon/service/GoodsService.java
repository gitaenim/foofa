package com.green.nowon.service;

import org.springframework.ui.Model;

public interface GoodsService {

	void findAll(Model model);

	void goodsOfCategory(long no, Model model);

}
