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

@RestController
@RequestMapping(value="/api/user")
public class UserController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public List<UserDto> getAll(){
		return userService.findAll();
	}
	
	@RequestMapping(value = "/admin/{oId}", method = RequestMethod.GET)
	public UserDto getById(@PathVariable(value = "oId") String oId) {
		return userService.findById(oId);
	}
	
	@RequestMapping(value = "/admin/", method = RequestMethod.POST)
	public UserDto create(@RequestBody UserDto userDto) {
		return userService.create(userDto);
	}
	
	@RequestMapping(value = "/admin/", method = RequestMethod.PUT)
	public void update(@RequestBody UserDto userDto) {
		userService.update(userDto);
	}
	
	@RequestMapping(value = "/admin/{oId}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "oId") String oId) {
		userService.delte(oId);
	}
}
