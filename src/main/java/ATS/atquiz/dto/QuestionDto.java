package ATS.atquiz.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDto {
	
	private String id;
	
	private String question;
	
	private String tag;
	
	private Integer level;
	
	public QuestionDto() {}
	
	public QuestionDto(String id, String question, String tag, Integer level) {
		this.id = id;
		this.question = question;
		this.tag = tag;
		this.level = level;
	}
	

}
