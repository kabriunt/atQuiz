package ATS.atquiz.service.Question;

import java.util.List;

import com.atsistema.formacion.Question.dto.QuestionDTO;


public interface QuestionService {
	
	/**
	 * Realiza la busqueda de todas las Questionas existentes (con paginacion)
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public List<QuestionDTO> findAll(Integer page, Integer size);
	
	/**
	 * Busca por Id
	 * 
	 * @param idQuestion
	 * @return
	 */
	public QuestionDTO findById(ObjectId idQuestion);
	
	/**
	 * Busca por Nombre
	 * 
	 * @param nameRoom
	 * @return
	 */
	public List<QuestionDTO> findByName(String nameRoom);
	
	/**
	 * Recupera todas las Salas de una Questiona 
	 * 
	 * @param idQuestion
	 * @return
	 */
	public List<RoomDTO> findRoomsByIdQuestion(ObjectId idQuestion);
	
	/**
	 * Crea una Questiona
	 * 
	 * @param c
	 * @return
	 */
	public QuestionDTO create(QuestionDTO c);
	
	/**
	 * Modifica una Questiona
	 * 
	 * @param c
	 */
	public void update(QuestionDTO c);

	/**
	 * Borra una Questiona
	 * 
	 * @param c
	 */
	public void delete(ObjectId idQuestion);
	
}
