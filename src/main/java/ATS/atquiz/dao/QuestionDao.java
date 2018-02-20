package ATS.atquiz.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ATS.atquiz.model.Question;

@Repository
public interface QuestionDao extends MongoRepository<Question, String>{
	
	public List<Question> findByTagAndLevel(String tag, Integer level);
}
