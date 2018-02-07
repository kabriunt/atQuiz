package ATS.atquiz.dto;

import java.io.Serializable;

import org.bson.types.ObjectId;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto implements Serializable{
	
	private static final long serialVersionUID = -7433188215556539347L;

	private ObjectId id;
	
	private String username;
	
	private String password;
	
	public UserDto(){}
	
	public UserDto(ObjectId id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
}
