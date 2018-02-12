package ATS.atquiz.service.Quiz;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ATS.atquiz.dao.QuizDao;
import ATS.atquiz.dto.QuestionDto;
import ATS.atquiz.dto.QuizDto;
import ATS.atquiz.model.Quiz;
import ATS.atquiz.model.User;
import ATS.atquiz.service.Question.QuestionService;

@Service
public class QuizServiceImpl implements QuizService{

	@Autowired
	private QuizDao quizDao;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private DozerBeanMapper mapper;
	
	@Override
	public List<QuizDto> findAll() {
		List<Quiz> quizs = quizDao.findAll();
		return quizs.stream().map(u->map(u)).collect(Collectors.toList());
	}

	@Override
	public List<QuizDto> findByUsername(String username) {
		List<Quiz> quizs = quizDao.findByUsername(username);
		return quizs.stream().map(u->map(u)).collect(Collectors.toList());
	}

	@Override
	public QuizDto create(QuizDto q) {
		final Quiz quiz = quizDao.save(map(q));
		return map(quiz);
	}
	
	@Override
	public QuizDto generatedQuiz(String tag, Integer level) {
		final List<QuestionDto> questions = questionService.findByTagAndLevel(tag, level);
		final QuizDto quizDto = new QuizDto("1",new Date(),new Date(),0.0,new User(),questions);
		return quizDto;
	}

	@Override
	public Quiz map(QuizDto dto) {
		return mapper.map(dto, Quiz.class);
	}

	@Override
	public QuizDto map(Quiz q) {
		return mapper.map(q, QuizDto.class);
	}

}
