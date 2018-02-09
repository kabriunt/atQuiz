package ATS.atquiz.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBooleanDto implements Serializable{
	
	
	private static final long serialVersionUID = 6387997671995409651L;

	private String id;
	
	private String username;
	
	private String password;
	
	private boolean nonExpiredAccount;
	
	private boolean nonLocked;
	
	private boolean nonExpiredCredentials;
	
	private boolean enabled;
	
	public UserBooleanDto(){}
	
	public UserBooleanDto(String id, String username, String password,
			boolean nonExpiredAccount, boolean nonLocked, boolean nonExpiredCredentials, boolean enabled) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.nonExpiredAccount = nonExpiredAccount;
		this.nonLocked = nonLocked;
		this.nonExpiredCredentials = nonExpiredCredentials;
		this.enabled = enabled;
	}
	
}
