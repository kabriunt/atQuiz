package ATS.atquiz.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ATS.atquiz.dto.QuestionDto;
import ATS.atquiz.service.Question.QuestionService;


@RestController
@RequestMapping(value="/api/Question")
public class QuestionController {

	@Autowired
private QuestionService questionService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<QuestionDto> findAll(@RequestParam(required=false, defaultValue="0") Integer page, @RequestParam(required=false, defaultValue="5") Integer size){
		return questionService.findAll(page,size);		
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public QuestionDto findById(@PathVariable ObjectId id) throws Exception {
		return questionService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public QuestionDto create(@RequestBody QuestionDto questionDto) {
		return questionService.create(questionDto);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody QuestionDto questionDto) {
		questionService.update(questionDto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") ObjectId id) {
		questionService.delete(id);
	}
	
}
