package ATS.atquiz.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import ATS.atquiz.model.Quiz;

@Repository
public interface QuizDao extends MongoRepository<Quiz, String>{

	@Query("{ user.username: ?0}")
	public List<Quiz> findByUsername(String username);
}
