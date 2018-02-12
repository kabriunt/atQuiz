package ATS.atquiz.service.user;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import ATS.atquiz.dao.UserDao;
import ATS.atquiz.dto.UserDto;
import ATS.atquiz.model.User;
import ATS.atquiz.service.User.UserService;
import ATS.atquiz.service.User.UserServiceImpl;
import Exception.InvalidDataException;
import Exception.NotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class TestUserService {
	
	private static final User user = new User();
	private static final List<User> users = new ArrayList<>();
	
	private static final UserDto userDto = new UserDto();
	private static final List<UserDto> userDtos = new ArrayList<>();
	
	private static String id = "2idilsw2q";
	private static String username = "admin";
	private static String password = "12345";
	private static String role = "ROLE_ADMIN";
	private static String name = "Emiliano";
	private static String dni = "243783827Q";
	private static String email = "emiliano12@hotmail.com";
	private boolean nonExpiredAccount = true;
	private boolean nonLocked = true;
	private boolean nonExpiredCredentials = true;
	private boolean enabled = true;
	
	@InjectMocks
	private UserService userService = new UserServiceImpl();
	
	@Mock
	private DozerBeanMapper mapper;
	
	@Mock
	private UserDao userDao;
	
	public void UserStarter() {
		user.setId(id);
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(role);
		user.setName(name);
		user.setDNI(dni);
		user.setEmail(email);
		user.setNonExpiredAccount(nonExpiredAccount);
		user.setNonLocked(nonLocked);
		user.setNonExpiredCredentials(nonExpiredCredentials);
		user.setEnabled(enabled);
		users.add(user);
	}
	
	public void UserDtoStarter() {
		userDto.setId(id);
		userDto.setUsername(username);
		userDto.setPassword(password);
		userDto.setRole(role);
		userDto.setName(name);
		userDto.setDNI(dni);
		userDto.setEmail(email);
		userDto.setNonExpiredAccount(nonExpiredAccount);
		userDto.setNonLocked(nonLocked);
		userDto.setNonExpiredCredentials(nonExpiredCredentials);
		userDto.setEnabled(enabled);
		userDtos.add(userDto);
	}
	
	public void Mockitos() {
		Mockito.when(userDao.findAll()).thenReturn(users);
		Mockito.when(userDao.findOne(id)).thenReturn(user);
		Mockito.when(mapper.map(user, UserDto.class)).thenReturn(userDto);
		Mockito.when(mapper.map(userDto, User.class)).thenReturn(user);
		Mockito.when(userDao.save(user)).thenReturn(user);
	}
	
	@Before
	public void Initializer() {
		UserStarter();
		UserDtoStarter();
		Mockitos();
	}
	
	@Test
	public void findAllTestFine() throws NotFoundException {
		final List<UserDto> res = userService.findAll();
		Assert.assertEquals(userDto, res.get(0));
	}
	
	@Test(expected = NotFoundException.class)
	public void findAllTestWrong() throws NotFoundException {
		Mockito.when(userDao.findAll()).thenReturn(null);
		userService.findAll();
	}
	
	@Test
	public void findByIdFine() throws NotFoundException {
		final UserDto res = userService.findById(id);
		Assert.assertEquals(userDto, res);
	}
	
	@Test(expected = NotFoundException.class)
	public void findByIdWrong() throws NotFoundException{
		userService.findById("dkkwkeowl78372");
	}
	
	@Test 
	public void createFine() throws InvalidDataException {
		final UserDto res = userService.create(userDto);
		Assert.assertEquals(user.getId(),res.getId());
		Assert.assertEquals(user.getUsername(),res.getUsername());
		Assert.assertEquals(user.getPassword(),res.getPassword());
		Assert.assertEquals(user.getRole(),res.getRole());
		Assert.assertEquals(user.getName(),res.getName());
		Assert.assertEquals(user.getDNI(),res.getDNI());
		Assert.assertEquals(user.getEmail(),res.getEmail());
		Assert.assertEquals(user.isNonLocked(), res.isNonLocked());
		Assert.assertEquals(user.isNonExpiredAccount(), res.isNonExpiredAccount());
		Assert.assertEquals(user.isNonExpiredCredentials(), res.isNonExpiredCredentials());
		Assert.assertEquals(user.isEnabled(), res.isEnabled());
	}
	
	@Test(expected = InvalidDataException.class)
	public void createWrong() throws InvalidDataException{
		userService.create(new UserDto());
	}
	
	@Test
	public void testUpdateFine() {
		userService.update(userDto);
	}
	
	@Test
	public void testDeleteFine() {
		userService.delete(id);
	}
}
