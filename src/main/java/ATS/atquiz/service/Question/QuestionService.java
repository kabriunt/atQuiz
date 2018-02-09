package ATS.atquiz.service.Question;

import java.util.List;

import ATS.atquiz.dto.AnswerDto;
import ATS.atquiz.dto.QuestionDto;
import ATS.atquiz.model.Question;


public interface QuestionService {
	
	
	public Question map(QuestionDto dto);
	
	public QuestionDto map(Question a);

	/**
	 * Realiza la busqueda de todas las Questionas existentes (con paginacion)
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public List<QuestionDto> findAll(Integer page, Integer size);
	
	/**
	 * Busca por Id
	 * 
	 * @param idQuestion
	 * @return
	 */
	public QuestionDto findById(String idQuestion)throws Exception;
	
	/**
	 * Crea una Questiona
	 * 
	 * @param c
	 * @return
	 */
	public QuestionDto create(QuestionDto a);
	
	/**
	 * Modifica una Questiona
	 * 
	 * @param c
	 */
	public void update(QuestionDto a);

	/**
	 * Borra una Questiona
	 * 
	 * @param c
	 */
	public void delete(String idQuestion);
	
	/**
	 * Añade una respuesta a una pregunta
	 * @param idQuestion
	 * @param answer
	 */
	void addAnswer(String idQuestion, AnswerDto answer);
	/**
	 * Actualiza una lista de preguntas
	 * @param idQuestion
	 * @param answers
	 */
	void updateAnswerList(String idQuestion, List<AnswerDto> answers);
	
}
