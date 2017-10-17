package st.fr.fdclick.back.films.services.interfaces;

import java.time.LocalDate;
import java.util.List;

import st.fr.fdclick.back.films.dtos.FilmWorkerDTO;

public interface IFilmWorkerService {
	FilmWorkerDTO addOrUpdate(FilmWorkerDTO filmWorkerDTO);
	void deleteById(String id);
	List<FilmWorkerDTO> findAll();
	FilmWorkerDTO findById(String id);
	
	List<FilmWorkerDTO> findByFirstNameContaining(String firstName);
	List<FilmWorkerDTO> findByLastNameContaining(String lastName);
	
	List<FilmWorkerDTO> findByBirthDateBetween(LocalDate startBirthDate, LocalDate endBirthDate);
	List<FilmWorkerDTO> findByFirstNameContainingAndLastNameContaining(String firstName, String lastName);
	
	List<FilmWorkerDTO> findByBirthDateBetweenAndFirstNameContaining(LocalDate startBirthDate, LocalDate endBirthDate, String firstName);
	List<FilmWorkerDTO> findByBirthDateBetweenAndLastNameContaining(LocalDate startBirthDate, LocalDate endBirthDate, String lastName);
	
	List<FilmWorkerDTO> findByBirthDateBetweenAndFirstNameContainingAndLastNameContaining(LocalDate startBirthDate, LocalDate endBirthDate, String firstName, String lastName);
}
