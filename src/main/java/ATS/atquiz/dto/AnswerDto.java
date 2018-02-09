package ATS.atquiz.dto;

public class AnswerDto {
	
	private String answer;
	
	private boolean ok;
	
	public AnswerDto() {}
	
	public AnswerDto(String answer, boolean ok) {
		this.answer = answer;
		this.ok = ok;
	}
}
