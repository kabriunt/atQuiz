package ATS.atquiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ATS.atquiz.dto.AnswerDto;
import ATS.atquiz.service.Answer.AnswerService;

@RestController
@RequestMapping(value="/api/answer")
public class AnswerController {

	@Autowired
	private AnswerService answerService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<AnswerDto> findAll(@RequestParam(required=false, defaultValue="0") Integer page, @RequestParam(required=false, defaultValue="5") Integer size){
		return answerService.findAll(page, size);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{idAnswer}")
	public AnswerDto findById(@PathVariable String idAnswer) throws Exception {
		return answerService.findById(idAnswer);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public AnswerDto create(@RequestBody AnswerDto a) {
		return answerService.create(a);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody AnswerDto a) {
		answerService.update(a);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idAnswer}")
	public void delete(@PathVariable String idAnswer) {
		answerService.delete(idAnswer);
	}
	
	
}
