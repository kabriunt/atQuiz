package ATS.atquiz.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import ATS.atquiz.model.User;

@Repository
public interface UserDao extends MongoRepository<User, String> {
	
	@Query("{ 'username' : ?0 }")
	User findByUsername(String username);
}
