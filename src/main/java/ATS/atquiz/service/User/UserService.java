package ATS.atquiz.service.User;

import java.util.List;

import ATS.atquiz.dto.UserDto;
import ATS.atquiz.model.User;

public interface UserService {
	
	User map(UserDto userDto);
	
	UserDto map(User user);
	
	List<UserDto> findAll();
	
	UserDto findById(String oId);
	
	UserDto create(UserDto userDto);
	
	void update(UserDto userDto);
	
	void delte(String oId);
}
