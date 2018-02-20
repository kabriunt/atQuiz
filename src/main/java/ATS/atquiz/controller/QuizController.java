package ATS.atquiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ATS.atquiz.dto.MarkDto;
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
	
	@RequestMapping(value = "/admin/quizs", method = RequestMethod.GET)
	public List<QuizDto> findQuizsByUsername(@RequestParam String username) throws NotFoundException{
		return quizService.findByUsername(username);
	}
	
	@RequestMapping(value = "/admin/quizs/marks", method = RequestMethod.GET)
	public List<MarkDto> getMarksByUsername(@RequestParam String username) throws NotFoundException{
		return quizService.getMarksByUsername(username);
	}
	
	@RequestMapping(value = "/generate", method = RequestMethod.GET)
	public QuizDto generateQuiz(@RequestParam String tag, @RequestParam Integer lvl,
			@RequestParam(defaultValue = "20") Integer nQuestions) throws NotFoundException {
		return quizService.generateQuiz(tag,lvl, nQuestions);
	}	
	
	@RequestMapping(value = "/candidate", method = RequestMethod.POST)
	public QuizDto create(@RequestBody QuizDto q) throws InvalidDataException {
		return quizService.create(q);
	}	
	
}
