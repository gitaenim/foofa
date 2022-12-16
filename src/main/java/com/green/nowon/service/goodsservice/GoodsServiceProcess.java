package com.green.nowon.service.goodsservice;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.green.nowon.domain.dto.GoodsInsertDTO;
import com.green.nowon.domain.entity.goods.GoodsEntity;
import com.green.nowon.domain.entity.goods.GoodsEntityRepository;
import com.green.nowon.domain.entity.goods.GoodsImgRepository;
import com.green.nowon.utils.MyFileUtils;

@Service
public class GoodsServiceProcess implements GoodsService {
	
	@Value("${file.location.temp}")
	private String tempUp;
	
	@Value("${file.location.upload}")
	private String upload;
	
	@Autowired
	GoodsEntityRepository grepo;
	
	@Autowired
	GoodsImgRepository girepo;
	
	@Override
	public Map<String, String> fileTempUp(MultipartFile gimg) {
		return MyFileUtils.fileUpload(gimg, tempUp);
	}

	@Override
	public void save(GoodsInsertDTO dto) {
		GoodsEntity entity=grepo.save(dto.toGoodsEntity());
		dto.toGoodsImg(entity, upload).forEach(girepo::save);
	}
}
