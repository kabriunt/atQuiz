package ATS.atquiz.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ATS.atquiz.model.Answer;

@Repository
public interface AnswerDao extends MongoRepository<Answer, ObjectId> {

}
