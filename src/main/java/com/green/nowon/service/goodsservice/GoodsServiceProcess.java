package com.green.nowon.service.goodsservice;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.green.nowon.utils.MyFileUtils;

@Service
public class GoodsServiceProcess implements GoodsService {
	
	@Value("${file.location.temp}")
	private String tempUpload;
	
	@Override
	public Map<String, String> fileTempUp(MultipartFile gimg) {
		
		return MyFileUtils.fileUpload(gimg, tempUpload);
	}

}
