package ATS.atquiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ATS.atquiz.dto.UserDto;

import ATS.atquiz.service.User.UserService;
import Exception.InvalidDataException;
import Exception.NotFoundException;

@RestController
@RequestMapping(value="/api/user/admin")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public List<UserDto> getAll() throws NotFoundException{
		return userService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserDto getById(@PathVariable(value = "id") String id) throws NotFoundException {
		return userService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public UserDto create(@RequestBody UserDto userDto) throws InvalidDataException {
		return userService.create(userDto);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody UserDto userDto) {
		userService.update(userDto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") String id) {
		userService.delete(id);
	}
}
