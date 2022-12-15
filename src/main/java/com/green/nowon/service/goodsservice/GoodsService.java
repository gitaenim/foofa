package com.green.nowon.service.goodsservice;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface GoodsService {

	Map<String, String> fileTempUp(MultipartFile gimg);

}
