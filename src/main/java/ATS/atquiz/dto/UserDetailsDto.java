package ATS.atquiz.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsDto implements Serializable{


	private static final long serialVersionUID = -7095998127708388357L;
	
	private String id;
	
	private String username;
	
	private String password;
	
	private String role;
	
	private String name;
	
	private String surname;
	
	private String email;
	
	private String DNI;

	public UserDetailsDto(){}
	
	public UserDetailsDto(String id, String username, String password, String role, String name,  String surname,  String email,
	 String DNI) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.DNI = DNI;
	}

}
