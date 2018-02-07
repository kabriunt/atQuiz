package ATS.atquiz.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Answer implements Serializable{
	
	private static final long serialVersionUID = -7799201071771170916L;

	@Id
	private String id;
	
	private String answer;
	
	private boolean ok;
	
}
