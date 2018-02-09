package ATS.atquiz.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerDto {
	
	private String answer;
	
	private boolean ok;
	
	public AnswerDto() {}
	
	public AnswerDto(String answer, boolean ok) {
		this.answer = answer;
		this.ok = ok;
	}
}
