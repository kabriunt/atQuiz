package ATS.atquiz.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDto {
	
	private String id;
	
	private String question;
	
	private String tag;
	
	private String level;
	
	private List<AnswerDto> answers;
	
	public QuestionDto() {}
	
	public QuestionDto(String id, String question, String tag, String level, List<AnswerDto> answers) {
		this.id = id;
		this.question = question;
		this.tag = tag;
		this.level = level;
		this.answers = answers;
	}
	

}
