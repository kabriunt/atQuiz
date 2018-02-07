package ATS.atquiz.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerDto {

	private String id;
	
	private String answer;
	
	private boolean ok;

	public AnswerDto() {}
	
	public AnswerDto(String id, String answer, boolean ok) {
		this.id = id;
		this.answer = answer;
		this.ok = ok;
	}
}
