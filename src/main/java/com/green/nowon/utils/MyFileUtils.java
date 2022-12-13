package com.green.nowon.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

public class MyFileUtils {

	public static Map<String, String> fileUpload(MultipartFile gimg, String location) {
		ClassPathResource cpr = new ClassPathResource("static"+location); //이 위치에 파일을 업로드 할거예요
		File folder=null;
		String fileName=null;
		try {
			folder = cpr.getFile();
			String orgName=gimg.getOriginalFilename();
			
			int idx = orgName.lastIndexOf("."); //인덱스번호찾기 - 파일 이름 중에서 마지막(.)의 인덱스번호
			String extension = orgName.substring(idx); // .확장자
			fileName = orgName.substring(0, idx) //(.확장자)를 제외한 파일 이름
					+"_"+ (System.nanoTime()/1000000)
					+ extension;
			//fileName = UUID.randomUUID().toString()+extension; //파일이름 랜덤으로 생성
		
			/*
			String[] strs=orgName.split("[.]");
			fileName = strs[0];
			for(int i=1; i<strs.length; i++) {
				String sep=".";
				if(i==strs.length-1) {
					long temp = System.nanoTime()/1000000;
					sep="_"+temp+".";
				}
				fileName += sep + strs[i];
			}
			*/
			
			//원본.이름_3515315315.jpg
			gimg.transferTo(new File(folder, fileName)); //업로드
			System.out.println("임시폴더에 파일업로드 : "+location+fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String, String> tempfile = new HashMap<>();
		tempfile.put("location", location);
		tempfile.put("fileName", fileName);
		tempfile.put("url", location+fileName);
		return tempfile;
	}
	
	private MyFileUtils() {} //생성자 막아버리기

}
