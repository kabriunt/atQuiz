package ATS.atquiz.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Answer {
	
	private String answer;
	
	private boolean ok;
	
	public Answer() {}
	
	public Answer(String answer, boolean ok) {
		this.answer = answer;
		this.ok = ok;
	}
}
