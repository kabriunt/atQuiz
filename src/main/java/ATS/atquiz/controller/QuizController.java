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

@RestController
@RequestMapping(value="/api/admin/quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<QuizDto> findAll(){
		return quizService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{username}")
	public List<QuizDto> findByUsername(@PathVariable String username){
		return quizService.findByUsername(username);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public QuizDto create(@RequestBody QuizDto q) {
		return quizService.create(q);
	}
	
	
}
