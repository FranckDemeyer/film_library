package st.fr.fdclick.back.films.webservices.interfaces;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import st.fr.fdclick.back.films.dtos.FilmDTO;

public interface IFilmWebService {
	ResponseEntity<FilmDTO> add(FilmDTO filmDTO);
	ResponseEntity<FilmDTO> update(FilmDTO filmDTO);
	void deleteById(String id);
	ResponseEntity<List<FilmDTO>> findAll();
	ResponseEntity<FilmDTO> findById(String id);
	
	ResponseEntity<List<FilmDTO>> findByActorsIdInOrDirectorsIdIn(List<String> workersIds);
	ResponseEntity<List<FilmDTO>> findByCategoriesIdIn(List<String> categoriesIds);
	ResponseEntity<FilmDTO> findByEAN(String EAN);
	ResponseEntity<List<FilmDTO>> findByNameContaining(String name);
	
	ResponseEntity<List<FilmDTO>> findByActorsIdInAndCategoriesIdInOrDirectorsInAndCategoriesIn(List<String> workersIds, List<String> categoriesIds);
	ResponseEntity<List<FilmDTO>> findByCategoriesIdInAndNameContaining(List<String> categoriesIds, String name);
	ResponseEntity<List<FilmDTO>> findByReleaseDateBetween(LocalDate startDate, LocalDate endDate);

	ResponseEntity<List<FilmDTO>> findByCategoriesIdInAndReleaseDateBetween(List<String> categoriesIds, LocalDate startDate, LocalDate endDate);
	ResponseEntity<List<FilmDTO>> findByNameContainingAndReleaseDateBetween(String name, LocalDate startDate, LocalDate endDate);
	
	ResponseEntity<List<FilmDTO>> findByCategoriesIdInAndNameContainingAndReleaseDateBetween(List<String> categoriesIds, String name, LocalDate startDate, LocalDate endDate);
}
