package ATS.atquiz.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto implements Serializable{
	
	private static final long serialVersionUID = -7433188215556539347L;

	private String id;
	
	private String username;
	
	private String password;
	
	private String role;
	
	private boolean enabled;
	
	public UserDto(){}
	
	public UserDto(String id, String username, String password, String role, boolean enabled) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
	}
	
}
