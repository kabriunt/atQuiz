package ATS.atquiz.service.Answer;

import java.util.List;

import ATS.atquiz.dto.AnswerDto;
import ATS.atquiz.model.Answer;

public interface AnswerService {

	public List<AnswerDto> findAll(Integer page, Integer size);
	
	public AnswerDto findById(String idAnswer) throws Exception;
	
	public AnswerDto create(AnswerDto a);

	public void update(AnswerDto a);

	public void delete(String idAnswer);

	public Answer map(AnswerDto dto);

	public AnswerDto map(Answer a);
}
