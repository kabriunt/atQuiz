package ATS.atquiz.service.User;

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
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public UserDto map(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto findById(ObjectId oId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto create(UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto update(UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delte(ObjectId oId) {
		// TODO Auto-generated method stub
		
	}

}
