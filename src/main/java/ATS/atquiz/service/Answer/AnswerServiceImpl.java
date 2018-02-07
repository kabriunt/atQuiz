package ATS.atquiz.service.Answer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ATS.atquiz.dao.AnswerDao;
import ATS.atquiz.dto.AnswerDto;
import ATS.atquiz.model.Answer;

@Service
public class AnswerServiceImpl implements AnswerService{
	
	@Autowired
	private AnswerDao answerDao;
	
	@Autowired
	private DozerBeanMapper mapper;
	
	@Override
	public List<AnswerDto> findAll(Integer page, Integer size){
		List<Answer> answers = answerDao.findAll(new PageRequest(page, size)).getContent();
		return answers.stream().map(u->map(u)).collect(Collectors.toList());
	}
	
	@Override
	public AnswerDto findById(String idAnswer) throws Exception{
		Answer answer = answerDao.findOne(idAnswer);
		return map(Optional.ofNullable(answer).orElseThrow(Exception::new));
	}
	
	@Override
	public AnswerDto create(AnswerDto a) {
		final Answer answer = answerDao.save(map(a));
		return map(answer);
	}
	
	@Override
	public void update(AnswerDto a) {
		final Answer answer = answerDao.save(map(a));
		map(answer);
	}
	
	@Override
	public void delete(String idAnswer) {
		answerDao.delete(idAnswer);
	}
	
	@Override
	public Answer map(AnswerDto dto) {
		return mapper.map(dto, Answer.class);
	}
	
	@Override
	public AnswerDto map(Answer a) {
		return mapper.map(a, AnswerDto.class);
	}

}
