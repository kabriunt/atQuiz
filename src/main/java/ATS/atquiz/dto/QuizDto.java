package ATS.atquiz.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import ATS.atquiz.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizDto implements Serializable{

	
	private static final long serialVersionUID = -2497382476162599801L;

	public String Id;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
	public Date dateQuiz;
	
	Double result;
	
	private User username;
	
	private List<QuestionDto> questions;
	
	public QuizDto() {}
	
	public QuizDto(String Id, Date dateQuiz, Double result, User username, List<QuestionDto> questions) {
		this.Id = Id;
		this.dateQuiz = dateQuiz;
		this.result = result;
		this.username = username;
		this.questions = questions;
	}
	
}
