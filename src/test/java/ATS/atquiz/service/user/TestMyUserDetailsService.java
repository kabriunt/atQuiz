package ATS.atquiz.service.user;

import org.bson.Document;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import ATS.atquiz.dto.UserDto;
import ATS.atquiz.service.User.MongoUserDetails;
import ATS.atquiz.service.User.MyUserDetailsService;

@RunWith(MockitoJUnitRunner.class)
public class TestMyUserDetailsService {
	
	private static MongoUserDetails mongoUserDetails;
	
	private static org.bson.Document document = new org.bson.Document();
	
	private static final String id = "12345ds";
	private static final String username = "admin";
	private static final String password = "12345";
	private static final String name = "Rebeca";
	private static final String role = "ROLE_ADMIN";
	private static final String surname = "Suárez";
	private static final String email = "rebeca@hotmail.com";
	private static final String dni = "234929321d";
	private static final boolean nonExpiredAccount = true;
	private static final boolean nonExpiredCredentials = true;
	private static final boolean nonLocked = true;
	private static final boolean enabled = true;
	
	@InjectMocks
	private UserDetailsService service = new MyUserDetailsService();
	
	@Mock
	private MongoClient mongoClient;
	
	@Mock
	private MongoCollection<org.bson.Document> collection;
	
	@Mock
	private MongoDatabase database;
	
	@Mock
	private FindIterable<Document> d;
	
	public void DocumentStarter() {
		document.put("id", id);
		document.put("username", username);
		document.put("password", password);
		document.put("role", role);
		document.put("name", name);
		document.put("surname", surname);
		document.put("email", email);
		document.put("dni", dni);
		document.put("nonExpiredAccount",nonExpiredAccount);
		document.put("nonExpiredCredentials",nonExpiredCredentials);
		document.put("nonLocked",nonLocked);
		document.put("enabled", enabled);
	}
	
	public void MongoUserDetailsStarter() {
		mongoUserDetails = new MongoUserDetails(new UserDto(id,username,password,role,name,surname,email,dni,
				nonExpiredAccount,nonExpiredCredentials,nonLocked,enabled));
	}
	
	public void Mockitos() {
		Mockito.when(mongoClient.getDatabase("quizdb")).thenReturn(database);
		Mockito.when(database.getCollection("user")).thenReturn(collection);
		Mockito.when(collection.find(Filters.eq(Mockito.anyString(),username))).thenReturn(d);
		Mockito.when(d.first()).thenReturn(document);
	}
	
	@Before
	public void Initializer() {
		DocumentStarter();
		MongoUserDetailsStarter();
		Mockitos();
	}
	
	@Test
	public void LoadUserByUsernameTestFine() {
		UserDetails res = service.loadUserByUsername(username);
		Assert.assertEquals(mongoUserDetails.getUsername(), res.getUsername());
		Assert.assertEquals(mongoUserDetails.getPassword(), res.getPassword());
		Assert.assertEquals(mongoUserDetails.getAuthorities(), res.getAuthorities());
		Assert.assertEquals(mongoUserDetails.isAccountNonExpired(), res.isAccountNonExpired());
		Assert.assertEquals(mongoUserDetails.isCredentialsNonExpired(), res.isCredentialsNonExpired());
		Assert.assertEquals(mongoUserDetails.isAccountNonLocked(), res.isAccountNonLocked());
		Assert.assertEquals(mongoUserDetails.isEnabled(), res.isEnabled());
	}
	
	@Test(expected = UsernameNotFoundException.class)
	public void LoadUserByUsernameTestWrong() {
		Mockito.when(d.first()).thenReturn(null);
		service.loadUserByUsername(username);
	}
}
