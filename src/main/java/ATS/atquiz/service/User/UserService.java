package ATS.atquiz.service.User;

import java.util.List;

import ATS.atquiz.dto.UserDto;
import ATS.atquiz.model.User;
import Exception.InvalidDataException;
import Exception.NotFoundException;

public interface UserService {
	
	User map(UserDto userDto);
	
	UserDto map(User user);
	
	List<UserDto> findAll() throws NotFoundException;
	
	UserDto findById(String oId) throws NotFoundException;
	
	UserDto findByUsername(String username) throws NotFoundException;
	
	UserDto create(UserDto userDto) throws InvalidDataException;
	
	void update(UserDto userDto);
	
	void delete(String oId);

	
}
