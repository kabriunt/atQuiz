package ATS.atquiz.service.Quiz;

import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ATS.atquiz.dao.QuizDao;
import ATS.atquiz.dto.QuizDto;
import ATS.atquiz.model.Quiz;

@Service
public class QuizServiceImpl implements QuizService{

	@Autowired
	private QuizDao quizDao;
	
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
	public Quiz map(QuizDto dto) {
		return mapper.map(dto, Quiz.class);
	}

	@Override
	public QuizDto map(Quiz q) {
		return mapper.map(q, QuizDto.class);
	}

}
