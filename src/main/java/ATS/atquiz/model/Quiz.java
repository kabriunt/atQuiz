package ATS.atquiz.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import ATS.atquiz.dto.QuestionDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Quiz implements Serializable{
	
	private static final long serialVersionUID = 6203808840822554471L;
	
	public String Id;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
	public Date dateQuiz;
	
	Double result;
	
	private User username;
	
	private List<QuestionDto> answers = new ArrayList<>();

}
