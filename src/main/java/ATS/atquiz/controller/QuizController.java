package ATS.atquiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ATS.atquiz.dto.QuizDto;
import ATS.atquiz.service.Quiz.QuizService;
import Exception.InvalidDataException;
import Exception.NotFoundException;

@RestController
@RequestMapping(value="/api/quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@RequestMapping(value = "/admin",method = RequestMethod.GET)
	public List<QuizDto> findAll() throws NotFoundException{
		return quizService.findAll();
	}
	
	@RequestMapping(value = "/admin/{username}", method = RequestMethod.GET)
	public List<QuizDto> findByUsername(@PathVariable String username) throws NotFoundException{
		return quizService.findByUsername(username);
	}
	
	@RequestMapping(value = "/generated", method = RequestMethod.GET)
	public QuizDto generatedQuiz() {
		return quizService.generatedQuiz("java",1);
	}	
	
	@RequestMapping(value = "/candidate", method = RequestMethod.POST)
	public QuizDto create(@RequestBody QuizDto q) throws InvalidDataException {
		return quizService.create(q);
	}	
	
}
