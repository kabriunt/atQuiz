package ATS.atquiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ATS.atquiz.dto.UserDto;

import ATS.atquiz.service.User.UserService;

@RestController
@RequestMapping(value="/api/admin/user")
public class UserController {
	
	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public List<UserDto> getAll(){
		return userService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserDto getById(@PathVariable(value = "id") String id) {
		return userService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public UserDto create(@RequestBody UserDto userDto) {
		return userService.create(userDto);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody UserDto userDto) {
		userService.update(userDto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") String id) {
		userService.delte(id);
	}
}
