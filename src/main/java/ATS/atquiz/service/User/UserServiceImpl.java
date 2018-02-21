package ATS.atquiz.service.User;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ATS.atquiz.dao.UserDao;
import ATS.atquiz.dto.UserDto;
import ATS.atquiz.model.User;
import Exception.InvalidDataException;
import Exception.NotFoundException;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private DozerBeanMapper mapper;
	
	@Override
	public User map(UserDto userDto) {
		return mapper.map(userDto, User.class);
	}
	
	@Override
	public UserDto map(User user) {
		return mapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> findAll() throws NotFoundException {
		Iterable<User> users = userDao.findAll();
		if(users!=null) {
			final List<UserDto> userDtos = new ArrayList<>();
			users.forEach(x->userDtos.add(map(x)));
			return userDtos;
		}
		throw new NotFoundException();
	}

	@Override
	public UserDto findById(String oId) throws NotFoundException{
		final User user = userDao.findOne(oId);
		if(user != null)
			return map(user);
		throw new NotFoundException();
	}
	
	@Override
	public UserDto findByUsername(String username) throws NotFoundException{
		final User user = userDao.findByUsername(username);
		if(user != null)
			return map(user);
		throw new NotFoundException();
	}

	private boolean validate(UserDto userDto) {
		return (userDto.getUsername() != null && userDto.getUsername() != "" && userDto.getPassword() != "" && userDto.getPassword() 
				!= null && userDto.getDNI() != null &&	userDto.getName() != null && userDto.getEmail() != null);
	}
	@Override
	public UserDto create(UserDto userDto) throws InvalidDataException {
		if(validate(userDto))
			return map(userDao.save(map(userDto)));
		throw new InvalidDataException("Error, faltan datos");
	}
	
	@Override
	public void update(UserDto userDto) {
		userDao.save(map(userDto));
	}

	@Override
	public void delete(String oId) {
		userDao.delete(oId);		
	}

}
