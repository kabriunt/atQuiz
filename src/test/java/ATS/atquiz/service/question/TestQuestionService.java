package ATS.atquiz.service.question;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import ATS.atquiz.dao.QuestionDao;
import ATS.atquiz.dto.Answer;
import ATS.atquiz.dto.QuestionDto;
import ATS.atquiz.model.Question;
import ATS.atquiz.service.Question.QuestionService;
import ATS.atquiz.service.Question.QuestionServiceImpl;
import Exception.InvalidDataException;
import Exception.NotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class TestQuestionService {
	
	private static final Question question = new Question();
	private static final List<Question> questions = new ArrayList<>();
	private Page<Question> questionsPage ;
	
	private static final QuestionDto questionDto = new QuestionDto();
	private static final List<QuestionDto> questionDtos = new ArrayList<>();
	
	private static final List<Answer> answerDtos = new ArrayList<>();
	
	private static final String id = "ewkle212";
	private static final String questionAttribute = "¿What?";
	private static final String tag = "common";
	private static final Integer level = 0;
	private static final Answer answer = new Answer("forget about it",true);
	
	@InjectMocks
	QuestionService questionService = new QuestionServiceImpl();
	
	@Mock
	QuestionDao questionDao;
	
	@Mock
	DozerBeanMapper mapper;
	
	public void QuestionStarter() {
		question.setId(id);
		question.setQuestion(questionAttribute);
		question.setTag(tag);
		question.setLevel(level);
		question.getAnswers().add(answer);
		questions.add(question);
		questionsPage = new PageImpl<>(questions);
	}
	
	public void QuestionDtoStarter() {
		questionDto.setId(id);
		questionDto.setQuestion(questionAttribute);
		questionDto.setTag(tag);
		questionDto.setLevel(level);
		questionDtos.add(questionDto);
	}
	
	public void Mockitos() {
		Mockito.when(questionDao.findAll(new PageRequest(0,10))).thenReturn(questionsPage);
		Mockito.when(questionDao.findOne(id)).thenReturn(question);
		Mockito.when(questionDao.save(question)).thenReturn(question);
		Mockito.when(mapper.map(question, QuestionDto.class)).thenReturn(questionDto);
		Mockito.when(mapper.map(questionDto, Question.class)).thenReturn(question);
		Mockito.when(questionDao.findByTagAndLevel(tag, level)).thenReturn(questions);
	}
	
	@Before
	public void Initializer() {
		QuestionStarter();
		QuestionDtoStarter();
		Mockitos();
	}
	
	@Test
	public void  findAllTestFine() throws NotFoundException {
		List<QuestionDto> res = questionService.findAll(0,10);
		Assert.assertEquals(questionDtos.get(0), res.get(0));
	}
	
	@Test(expected = NotFoundException.class)
	public void  findAllTestWrong() throws NotFoundException {
		Mockito.when(questionDao.findAll(new PageRequest(0,10))).thenReturn(null);
		questionService.findAll(0,10);
	}
	
	@Test
	public void findByIdFine() throws NotFoundException {
		QuestionDto res = questionService.findById(id);
		Assert.assertEquals(questionDto.getId(), res.getId());
		Assert.assertEquals(questionDto.getQuestion(), res.getQuestion());
		Assert.assertEquals(questionDto.getTag(), res.getTag());
	}
	
	@Test(expected = NotFoundException.class)
	public void findByIdWrong() throws NotFoundException {
		questionService.findById("29012udjk");
	}
	
	@Test
	public void createFine() throws InvalidDataException {
		QuestionDto res = questionService.create(questionDto);
		Assert.assertEquals(questionDto.getId(), res.getId());
		Assert.assertEquals(questionDto.getQuestion(), res.getQuestion());
		Assert.assertEquals(questionDto.getTag(), res.getTag());
	}
	
	
	@Test( expected = InvalidDataException.class)
	public void createWrong() throws InvalidDataException{
		questionService.create(new QuestionDto());
	}
	
	@Test
	public void testUpdateFine() {
		questionService.update(questionDto);
	}
	
	@Test
	public void testDeleteFine() {
		questionService.delete(id);
	}
	
	@Test
	public void testAddAnswer() {
		questionService.addAnswer(id, new Answer());
	}
	
	@Test
	public void testUpdateAnswer() {
		questionService.updateAnswerList(id, answerDtos);
	}
	
	@Test
	public void testFindByTagAndLevel() {
		List<QuestionDto> res = questionService.findByTagAndLevel(tag, level);
		Assert.assertEquals(questionDtos, res);
	}
	
}
