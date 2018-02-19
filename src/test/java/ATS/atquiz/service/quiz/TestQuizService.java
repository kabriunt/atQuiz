package ATS.atquiz.service.quiz;

import java.util.ArrayList;
import java.util.Date;
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

import ATS.atquiz.dao.QuizDao;
import ATS.atquiz.dto.QuestionDto;
import ATS.atquiz.dto.QuizDto;
import ATS.atquiz.model.Quiz;
import ATS.atquiz.model.User;
import ATS.atquiz.service.Question.QuestionService;
import ATS.atquiz.service.Quiz.QuizService;
import ATS.atquiz.service.Quiz.QuizServiceImpl;
import Exception.InvalidDataException;
import Exception.NotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class TestQuizService {

	private static final Quiz quiz = new Quiz();
	private static final List<Quiz> quizs = new ArrayList<>();
	
	private static final QuizDto quizDto = new QuizDto();
	private static final List<QuizDto> quizDtos = new ArrayList<>();
	
	private static final String id = "eu231wp7q";
	private static final Date d = new Date();
	private static final User user = new User();
	private static final String username = "pablito2";
	
	private static final QuestionDto questionDto = new QuestionDto();
	private static final List<QuestionDto> questionDtos = new ArrayList<>();
	
	private static final String questionAttribute = "¿What?";
	private static final String tag = "common";
	private static final Integer level = 0;
	
	@InjectMocks 
	QuizService quizService = new QuizServiceImpl();
	
	@Mock
	QuizDao quizDao;
	
	@Mock
	DozerBeanMapper mapper;
	
	@Mock
	QuestionService questionService;
	
	public void QuizStarter() {
		quiz.setId(id);
		quiz.setDateIni(d);
		quiz.setDateEnd(d);
		quiz.setUser(user);
		quizs.add(quiz);
	}
	
	public void QuizDtoStarter() {
		quizDto.setId(id);
		quizDto.setDateIni(d);
		quizDto.setDateEnd(d);
		quizDto.setUser(user);
		quizDto.setQuestions(questionDtos);
		quizDtos.add(quizDto);		
	}
	
	public void QuestionDtoStarter() {
		questionDto.setId(id);
		questionDto.setQuestion(questionAttribute);
		questionDto.setTag(tag);
		questionDto.setLevel(level);
		questionDtos.add(questionDto);
	}
	
	public void Mockitos() {
		Mockito.when(quizDao.findAll()).thenReturn(quizs);
		Mockito.when(quizDao.findByUsername(username)).thenReturn(quizs);
		Mockito.when(mapper.map(quiz, QuizDto.class)).thenReturn(quizDto);
		Mockito.when(mapper.map(quizDto, Quiz.class)).thenReturn(quiz);
		Mockito.when(quizDao.save(quiz)).thenReturn(quiz);
		Mockito.when(questionService.findByTagAndLevel(tag, level)).thenReturn(questionDtos);
	}
	
	@Before
	public void Initializer() {
		QuizStarter();
		QuizDtoStarter();
		QuestionDtoStarter();
		Mockitos();
	}
	
	@Test
	public void findAllTestFine() throws NotFoundException {
		List<QuizDto> res = quizService.findAll();
		Assert.assertEquals(quizDtos, res);
	}
	
	@Test(expected = NotFoundException.class)
	public void findAllTestWrong() throws NotFoundException{
		Mockito.when(quizDao.findAll()).thenReturn(null);
		quizService.findAll();
	}
	
	@Test
	public void findByUsernameTestFine() throws NotFoundException {
		List<QuizDto> res = quizService.findByUsername(username);
		Assert.assertEquals(quizDto, res.get(0));
	}
	
	@Test(expected = NotFoundException.class)
	public void findByUsernameTestWrong() throws NotFoundException{
		Mockito.when(quizDao.findByUsername(username)).thenReturn(null);
		quizService.findByUsername(username);
	}
	
	@Test 
	public void createTestFine() throws InvalidDataException {
		QuizDto res = quizService.create(quizDto);
		Assert.assertEquals(quizDto.getId(), res.getId());
		Assert.assertEquals(quizDto.getDateIni(), res.getDateIni());
		Assert.assertEquals(quizDto.getDateEnd(), res.getDateEnd());
		Assert.assertEquals(quizDto.getUser(), res.getUser());
	}	
	
	@Test(expected = InvalidDataException.class)
	public void createTestWrong() throws InvalidDataException {
		quizService.create(new QuizDto());
	}
	
	@Test
	public void generateQuizTest() throws NotFoundException {
		QuizDto res = quizService.generateQuiz(tag, level,10);
		Assert.assertEquals("1", res.getId());
		Assert.assertEquals(new Date(), res.getDateIni());
		Assert.assertEquals(new Date(), res.getDateEnd());
		Assert.assertEquals(quizDto.getQuestions().get(0), res.getQuestions().get(0));
	}
	
}
