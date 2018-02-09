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
	
	private String name;
	
	private String surname;
	
	private String email;
	
	private String DNI;
	
	private boolean nonExpiredAccount;
	
	private boolean nonLocked;
	
	private boolean nonExpiredCredentials;
	
	private boolean enabled;
	
	public UserDto(){}
	
	public UserDto(String id, String username, String password, String role, String name,  String surname,  String email,
	 String DNI, boolean nonExpiredAccount, boolean nonLocked, boolean nonExpiredCredentials, boolean enabled) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.DNI = DNI;
		this.nonExpiredAccount = nonExpiredAccount;
		this.nonLocked = nonLocked;
		this.nonExpiredCredentials = nonExpiredCredentials;
		this.enabled = enabled;
	}
	
}
