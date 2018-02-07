package ATS.atquiz.service.User;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ATS.atquiz.dao.UserDao;
import ATS.atquiz.dto.UserDto;
import ATS.atquiz.model.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	
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
	public List<UserDto> findAll() {
		Iterable<User> users = userDao.findAll();
		final List<UserDto> userDtos = new ArrayList<>();
		users.forEach(x->userDtos.add(map(x)));
		return userDtos;
	}

	@Override
	public UserDto findById(String oId) {
		final User user = userDao.findOne(oId);
		return map(user);
	}

	@Override
	public UserDto create(UserDto userDto) {
		return map(userDao.save(map(userDto)));
	}

	@Override
	public void update(UserDto userDto) {
		userDao.save(map(userDto));
	}

	@Override
	public void delte(String oId) {
		userDao.delete(oId);		
	}

}
