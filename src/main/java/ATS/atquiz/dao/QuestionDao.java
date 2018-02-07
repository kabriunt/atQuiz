package ATS.atquiz.dao;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao extends MongoRepository<ObjectId, Serializable>
{

	
}
