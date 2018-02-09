package ATS.atquiz.service.Quiz;

import java.util.List;

import ATS.atquiz.dto.QuizDto;
import ATS.atquiz.model.Quiz;

public interface QuizService {

	public List<QuizDto> findAll();
	
	public List<QuizDto> findByUsername(String username);
	
	public QuizDto create(QuizDto q);
	
	public Quiz map(QuizDto dto);
	
	public QuizDto map(Quiz q);
}
