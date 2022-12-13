package com.green.nowon.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.green.nowon.service.GoodsService;
import com.green.nowon.utils.MyFileUtils;

@Service
public class GoodsServiceProcess implements GoodsService {

	//A common use case is to inject values using #{systemProperties.myProp} style SpEL (Spring Expression Language)expressions. Alternatively, values may be injected using ${my.app.myProp} style property placeholders. 
	@Value("${file.location.temp}") //@Value를 통해 properties에서 value를 가져와 injection할 수 있어요
	private String locationTemp; //파일업로드위치
	
	@Override
	public Map<String, String> fileTempUpload(MultipartFile gimg) {
		return MyFileUtils.fileUpload(gimg, locationTemp);
	}

}
