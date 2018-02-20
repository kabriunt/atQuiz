package ATS.atquiz.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDto implements Serializable {

	private static final long serialVersionUID = -5158396529009785582L;

	private String id;
	
	private String question;
	
	private String tag;
	
	private Integer level;
	
	private List<Answer> answers;
	
	public QuestionDto() {}
	
	public QuestionDto(String id, String question, String tag, Integer level, List<Answer> answers) {
		this.id = id;
		this.question = question;
		this.tag = tag;
		this.level = level;
		this.answers = answers;
	}
	

}
