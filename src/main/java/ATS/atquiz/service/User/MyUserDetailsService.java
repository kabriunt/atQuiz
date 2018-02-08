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
            boolean dNonExpiredAccount= document.getBoolean("nonExpiredAccount");
            boolean dNonExpiredCredentials = document.getBoolean("nonExpiredCredentials");
            boolean dNonLocked = document.getBoolean("nonLocked");
            boolean dEnabled = document.getBoolean("enabled");
            MongoUserDetails mongoUserDetails = new  MongoUserDetails(new UserDto(dId, dUsername, dPassword, dRole,
            		dNonExpiredAccount, dNonLocked, dNonExpiredCredentials, dEnabled));
 
            return mongoUserDetails;
        } else {
 
           throw new UsernameNotFoundException("username not found");
        }
    }
}