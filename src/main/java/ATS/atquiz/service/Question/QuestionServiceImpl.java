package ATS.atquiz.service.Question;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ATS.atquiz.dao.QuestionDao;
import ATS.atquiz.dto.QuestionDto;
import ATS.atquiz.model.Question;

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
	public List<QuestionDto> findAll(Integer page, Integer size){
		List<Question> questions = questionDao.findAll(new PageRequest(page, size)).getContent();
		return questions.stream().map(u->map(u)).collect(Collectors.toList());
	}
	
	@Override
	public QuestionDto findById(ObjectId idQuestion)throws Exception{
		Question question = questionDao.findOne(idQuestion);
		return map(Optional.ofNullable(question).orElseThrow(Exception::new));
	}
	
	@Override
	public QuestionDto create(QuestionDto a) {
		final Question question = questionDao.save(map(a));
		return map(question);
	}
	
	@Override
	public void update(QuestionDto a) {
		final Question question = questionDao.save(map(a));
		map(question);
	}
	
	@Override
	public void delete(ObjectId idQuestion) {
		questionDao.delete(idQuestion);
	}

}
