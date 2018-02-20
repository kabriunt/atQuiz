package ATS.atquiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ATS.atquiz.dto.Answer;
import ATS.atquiz.dto.QuestionDto;
import ATS.atquiz.service.Question.QuestionService;
import Exception.InvalidDataException;
import Exception.NotFoundException;


@RestController
@RequestMapping(value="/api/question/admin")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<QuestionDto> findAll(@RequestParam(required=false, defaultValue="0") Integer page,
			@RequestParam(required=false, defaultValue="5") Integer size) throws NotFoundException{
		return questionService.findAll(page,size);		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/quiz")
	public List<QuestionDto> findByTagAndLevel(@RequestParam(required=false) String tag, @RequestParam(required=false) Integer level){
		return questionService.findByTagAndLevel(tag,level);		
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public QuestionDto findById(@PathVariable String id) throws Exception {
		return questionService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public QuestionDto create(@RequestBody QuestionDto questionDto) throws InvalidDataException {
		return questionService.create(questionDto);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody QuestionDto questionDto) {
		questionService.update(questionDto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") String id) {
		questionService.delete(id);
	}
	
	@RequestMapping(value = "/{id}/newAnswer", method = RequestMethod.POST)
	public void addAnswer(@PathVariable String id, @RequestBody Answer answerDto) {
		questionService.addAnswer(id, answerDto);
	}
	
	@RequestMapping(value = "/{id}/updateAnswerList", method = RequestMethod.POST)
	public void updateAnswerList(@PathVariable String id, @RequestBody List<Answer> answerDtos) {
		questionService.updateAnswerList(id, answerDtos);
	}
	
}
