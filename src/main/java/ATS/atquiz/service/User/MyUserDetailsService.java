package ATS.atquiz.service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ATS.atquiz.service.User.MongoUserDetails;
import lombok.extern.slf4j.Slf4j;
import ATS.atquiz.dto.UserDto;

@Slf4j
@Service
public class MyUserDetailsService implements UserDetailsService {
 
	@Autowired
    private MongoClient mongoClient;
 
    @Override
    public UserDetails loadUserByUsername(String username) {
    	MongoDatabase database = mongoClient.getDatabase("quizdb");
        MongoCollection<org.bson.Document> collection = database.getCollection("user");
 
        org.bson.Document document = collection.find(Filters.eq("username",username)).first();
 
        if(document!=null) {
        	String dId = document.getString("id");
            String dUsername = document.getString("username");
            String dPassword = document.getString("password");
            String dRole= document.getString("role");
            boolean dEnabled = document.getBoolean("enabled");
            log.info("Username: "+dUsername);
            log.info("Password: "+dPassword);
            log.info("Rol: "+dRole);
            MongoUserDetails mongoUserDetails = new  MongoUserDetails(new UserDto(dId, dUsername, dPassword, dRole, dEnabled));
 
            return mongoUserDetails;
        } else {
 
           throw new UsernameNotFoundException("username not found");
        }
    }
}