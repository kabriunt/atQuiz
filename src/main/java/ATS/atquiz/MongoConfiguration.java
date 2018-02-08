package ATS.atquiz;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
@Configuration
public class MongoConfiguration {
 
    @Bean
    public MongoClient createConnection() {
 
        //You should put your mongo ip here
        return new MongoClient("localhost:27017");
    }
}