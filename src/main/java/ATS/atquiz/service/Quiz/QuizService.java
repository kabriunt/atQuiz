package ATS.atquiz.service.Quiz;

import java.util.List;

import ATS.atquiz.dto.MarkDto;
import ATS.atquiz.dto.QuizDto;
import ATS.atquiz.model.Quiz;
import Exception.InvalidDataException;
import Exception.NotFoundException;

public interface QuizService {

	public List<QuizDto> findAll() throws NotFoundException;
	
	public List<QuizDto> findByUsername(String username) throws NotFoundException;
	
	public QuizDto create(QuizDto q) throws InvalidDataException;
	
	public Quiz map(QuizDto dto);
	
	public QuizDto map(Quiz q);

	public QuizDto generateQuiz(String tag, Integer level, Integer nQuestions) throws NotFoundException;

	List<MarkDto> getMarksByUsername(String username) throws NotFoundException;
}
