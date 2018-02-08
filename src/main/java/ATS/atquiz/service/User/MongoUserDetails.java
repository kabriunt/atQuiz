package ATS.atquiz.service.User;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import ATS.atquiz.dto.UserDto;

public class MongoUserDetails implements UserDetails {

	private static final long serialVersionUID = -8703113019023065040L;
	
	private UserDto userDto;
	
    public MongoUserDetails(UserDto userDto) {
        this.userDto = userDto;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String[] authorities = {userDto.getRole()};
		return AuthorityUtils.createAuthorityList(authorities);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userDto.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userDto.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return userDto.isEnabled();
	}
}