package ATS.atquiz.service.Answer;

import java.util.List;

import org.bson.types.ObjectId;

import ATS.atquiz.dto.AnswerDto;
import ATS.atquiz.model.Answer;

public interface AnswerService {

	public List<AnswerDto> findAll(Integer page, Integer size);
	
	public AnswerDto findById(ObjectId idAnswer) throws Exception;
	
	public AnswerDto create(AnswerDto a);

	public void update(AnswerDto a);

	public void delete(ObjectId idAnswer);

	public Answer map(AnswerDto dto);

	public AnswerDto map(Answer a);
}
