package com.green.nowon.service.goodsservice;

import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.green.nowon.domain.dto.GoodsInsertDTO;

public interface GoodsService {

	Map<String, String> fileTempUp(MultipartFile gimg);

	void save(GoodsInsertDTO dto);
	
	void list(Model model);

	void goodsOfCategory(long no, Model model);

	void list(Model model);

	void goodsOfCategory(long no, Model model);
}
