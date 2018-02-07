package ATS.atquiz.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document
public class Question implements Serializable{
	
	private static final long serialVersionUID = -2641110345493075094L;

	@Id
	private String id;
	
	private String question;
	
	private String tag;
	
	private Integer level;
	
	@DBRef
	private List<Answer> answers = new ArrayList<>();
	
	

}
