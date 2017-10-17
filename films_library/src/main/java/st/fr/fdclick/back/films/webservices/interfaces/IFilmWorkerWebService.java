package st.fr.fdclick.back.films.webservices.interfaces;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import st.fr.fdclick.back.films.dtos.FilmWorkerDTO;

public interface IFilmWorkerWebService {
	ResponseEntity<FilmWorkerDTO> add(FilmWorkerDTO filmWorkerDTO);
	ResponseEntity<FilmWorkerDTO> update(FilmWorkerDTO filmWorkerDTO);
	void deleteById(String id);
	ResponseEntity<List<FilmWorkerDTO>> findAll();
	ResponseEntity<FilmWorkerDTO> findById(String id);
	
	ResponseEntity<List<FilmWorkerDTO>> findByFirstNameContaining(String firstName);
	ResponseEntity<List<FilmWorkerDTO>> findByLastNameContaining(String lastName);
	
	ResponseEntity<List<FilmWorkerDTO>> findByBirthDateBetween(LocalDate startBirthDate, LocalDate endBirthDate);
	ResponseEntity<List<FilmWorkerDTO>> findByFirstNameContainingAndLastNameContaining(String firstName, String lastName);
	
	ResponseEntity<List<FilmWorkerDTO>> findByBirthDateBetweenAndFirstNameContaining(LocalDate startBirthDate, LocalDate endBirthDate, String firstName);
	ResponseEntity<List<FilmWorkerDTO>> findByBirthDateBetweenAndLastNameContaining(LocalDate startBirthDate, LocalDate endBirthDate, String lastName);
	
	ResponseEntity<List<FilmWorkerDTO>> findByBirthDateBetweenAndFirstNameContainingAndLastNameContaining(LocalDate startBirthDate, LocalDate endBirthDate, String firstName, String lastName);

}
