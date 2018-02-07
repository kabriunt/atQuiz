package ATS.atquiz.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document
public class Question implements Serializable{
	
	private static final long serialVersionUID = -2641110345493075094L;

	private ObjectId Id;
	
	private String question;
	
	private String tags;
	
	private List<Answer> answers = new ArrayList<>();
	
	

}
