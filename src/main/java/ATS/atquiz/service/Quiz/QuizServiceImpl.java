package ATS.atquiz.service.Quiz;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ATS.atquiz.dao.QuizDao;
import ATS.atquiz.dto.QuestionDto;
import ATS.atquiz.dto.QuizDto;
import ATS.atquiz.dto.UserDto;
import ATS.atquiz.model.Quiz;
import ATS.atquiz.service.Question.QuestionService;
import ATS.atquiz.service.User.UserService;
import Exception.InvalidDataException;
import Exception.NotFoundException;

@Service
public class QuizServiceImpl implements QuizService{

	@Autowired
	private QuizDao quizDao;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DozerBeanMapper mapper;
	
	@Override
	public List<QuizDto> findAll() throws NotFoundException {
		Iterable<Quiz> quizs = quizDao.findAll();
		if(quizs!=null) {
			final List<QuizDto> quizDtos = new ArrayList<>();
			quizs.forEach(x->quizDtos.add(map(x)));
			return quizDtos;
		}
		throw new NotFoundException();
	}

	@Override
	public List<QuizDto> findByUsername(String username) throws NotFoundException {
		List<Quiz> quizs = quizDao.findByUsername(username);
		if(quizs!=null) {
			final List<QuizDto> quizDtos = new ArrayList<>();
			quizs.forEach(x->quizDtos.add(map(x)));
			return quizDtos;
		}
		throw new NotFoundException();
	}

	private boolean validate(QuizDto quizDto) {
		return (quizDto.getDateIni() != null && quizDto.getDateEnd() != null);
	}
	
	@Override
	public QuizDto create(QuizDto q) throws InvalidDataException {
		if(validate(q)) {
			final Quiz quiz = quizDao.save(map(q));
			return map(quiz);
		}
		throw new InvalidDataException("Error, faltan datos");
	}
	
	@Override
	public QuizDto generateQuiz(String tag, Integer level, Integer nQuestions) throws NotFoundException {
		List<QuestionDto> questions = questionService.findByTagAndLevel(tag, level);
		Collections.shuffle(questions);
		nQuestions=(nQuestions >= questions.size())?questions.size():nQuestions;
		if(nQuestions>=questions.size())
			nQuestions = questions.size();
		questions = questions.subList(0, nQuestions);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDto user = userService.findByUsername(authentication.getName());
		final QuizDto quizDto = new QuizDto(null, new Date(), new Date(),0.0, userService.map(user),questions);
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
