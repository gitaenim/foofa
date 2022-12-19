package com.green.nowon.domain.dto.faq;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Builder //args 존재하는 생성자와 함께 쓸 수 있어요 : 빌더패턴을 통해서 객체 생성을 지원합니다.(장점 : 가독성 증가, 파라미터 순서 노상관)
//@AllArgsConstructor
@ToString
@Getter
@Setter
public class FaqDTO {
	private String division;
	private String question;
	private String answer;
	
	public FaqDTO(String division, String question, String answer) {
		this.division = division;
		this.question = question;
		this.answer = answer;
	}
	
	//내부클래스 객체를 생성시켜주는 메서드
	public static FaqDTOBuilder builder() {
		return new FaqDTOBuilder();
	}
	//inner class
	public static class FaqDTOBuilder{
		private String division;
		private String question;
		private String answer;
		
		public FaqDTOBuilder division(String division) { //setter기능+return
			this.division=division;
			return this; //this=FaqDTOBuilder
		}
		
		public FaqDTOBuilder question(String question) { //setter기능+return
			this.question=question;
			return this; //this=FaqDTOBuilder
		}
		
		public FaqDTOBuilder answer(String answer) { //setter기능+return
			this.answer=answer;
			return this; //this=FaqDTOBuilder
		}
		
		public FaqDTO build() { //호출하면 객체 만들어짐
			return new FaqDTO(division, question, answer);
		}
		//FaqDTO dto = new FaqDTO(division, question, answer); //외부에서 객체 만들때
	}

}
