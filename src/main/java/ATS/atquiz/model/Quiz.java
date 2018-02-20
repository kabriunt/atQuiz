package ATS.atquiz.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Quiz implements Serializable{
	
	private static final long serialVersionUID = 6203808840822554471L;
	
	public String id;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
	public Date dateIni;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
	public Date dateEnd;
	
	Double mark;
	
	private User user;
	
	private List<Question> questions = new ArrayList<>();

}
