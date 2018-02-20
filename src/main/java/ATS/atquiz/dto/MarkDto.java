package ATS.atquiz.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarkDto implements Serializable{

	private static final long serialVersionUID = 7383088068092520707L;
	
	private String id;
	
	private Double mark;
	
	MarkDto(){}
	
	MarkDto(String id, Double mark){
		this.id = id;
		this.mark = mark;
	}

}
