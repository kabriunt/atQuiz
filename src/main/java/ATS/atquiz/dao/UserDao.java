package ATS.atquiz.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ATS.atquiz.model.User;

@Repository
public interface UserDao extends MongoRepository<User, String> {

}
