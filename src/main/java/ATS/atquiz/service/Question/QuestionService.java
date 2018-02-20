package ATS.atquiz.service.Question;

import java.util.List;

import ATS.atquiz.dto.Answer;
import ATS.atquiz.dto.QuestionDto;
import ATS.atquiz.model.Question;
import Exception.InvalidDataException;
import Exception.NotFoundException;


public interface QuestionService {
	
	
	public Question map(QuestionDto dto);
	
	public QuestionDto map(Question a);

	/**
	 * Realiza la busqueda de todas las Questionas existentes (con paginacion)
	 * 
	 * @param page
	 * @param size
	 * @return
	 * @throws NotFoundException 
	 */
	public List<QuestionDto> findAll(Integer page, Integer size) throws NotFoundException;
	
	public List<QuestionDto> findByTagAndLevel(String tag, Integer level);
	
	/**
	 * Busca por Id
	 * 
	 * @param idQuestion
	 * @return
	 */
	public QuestionDto findById(String idQuestion)throws NotFoundException;
	
	/**
	 * Crea una Questiona
	 * 
	 * @param c
	 * @return
	 * @throws InvalidDataException 
	 */
	public QuestionDto create(QuestionDto a) throws InvalidDataException;
	
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
	void addAnswer(String idQuestion, Answer answer);
	/**
	 * Actualiza una lista de preguntas
	 * @param idQuestion
	 * @param answers
	 */
	void updateAnswerList(String idQuestion, List<Answer> answers);
	
}
