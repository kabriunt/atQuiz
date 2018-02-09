package ATS.atquiz.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import ATS.atquiz.dto.AnswerDto;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document
public class Question implements Serializable{
	
	private static final long serialVersionUID = -2641110345493075094L;

	private String Id;
	
	private String question;
	
	private String tag;
	
	private String level;
	
	private List<AnswerDto> answers = new ArrayList<>();
	
	

}
