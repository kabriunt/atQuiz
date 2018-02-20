package ATS.atquiz.service.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ATS.atquiz.dao.QuestionDao;
import ATS.atquiz.dto.Answer;
import ATS.atquiz.dto.QuestionDto;
import ATS.atquiz.model.Question;
import Exception.InvalidDataException;
import Exception.NotFoundException;

@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionDao questionDao;
	
	
	@Autowired
	private DozerBeanMapper mapper;
	
	@Override
	public Question map(QuestionDto dto) {
		return mapper.map(dto, Question.class);
	}
	
	@Override
	public QuestionDto map(Question a) {
		return mapper.map(a, QuestionDto.class);
	}
	
	@Override
	public List<QuestionDto> findAll(Integer page, Integer size) throws NotFoundException{
		Iterable<Question> questions = questionDao.findAll(new PageRequest(page, size));
		if(questions!=null) {
			final List<QuestionDto> questionDtos = new ArrayList<>();
			questions.forEach(x->questionDtos.add(map(x)));
			return questionDtos;
		}
		throw new NotFoundException();
	}
	
	@Override
	public QuestionDto findById(String idQuestion)throws NotFoundException{
		Question question = questionDao.findOne(idQuestion);
		return map(Optional.ofNullable(question).orElseThrow(NotFoundException::new));
	}
	
	private boolean validate(QuestionDto a) {
		return (a.getId() != null && a.getLevel() != null && a.getTag() != null);
	}
	
	@Override
	public QuestionDto create(QuestionDto a) throws InvalidDataException {
		if(validate(a)) {
			final Question question = questionDao.save(map(a));
			return map(question);
		}
		throw new InvalidDataException("Error, faltan datos");
	}
	
	@Override
	public void update(QuestionDto a) {
		final Question question = questionDao.save(map(a));
		map(question);
	}
	
	@Override
	public void delete(String idQuestion) {
		questionDao.delete(idQuestion);
	}
	
	@Override
	public void addAnswer(String idQuestion, Answer answer) {
		final Question q = questionDao.findOne(idQuestion);
		q.getAnswers().add(answer);
		questionDao.save(q);
	}
	
	@Override
	public void updateAnswerList(String idQuestion, List<Answer> answers) {
		final Question q = questionDao.findOne(idQuestion);
		q.setAnswers(answers);
		questionDao.save(q);
	}

	@Override
	public List<QuestionDto> findByTagAndLevel(String tag, Integer level) {
		List<Question> questions = questionDao.findByTagAndLevel(tag,level);
		return questions.stream().map(u->map(u)).collect(Collectors.toList());
	}
}
