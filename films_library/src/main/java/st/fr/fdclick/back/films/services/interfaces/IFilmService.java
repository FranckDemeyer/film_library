package st.fr.fdclick.back.films.services.interfaces;

import java.time.LocalDate;
import java.util.List;

import st.fr.fdclick.back.films.dtos.FilmDTO;

public interface IFilmService {
	FilmDTO addOrUpdate(FilmDTO filmDTO);
	void deleteById(String id);
	List<FilmDTO> findAll();
	FilmDTO findById(String id);
	
	List<FilmDTO> findByActorsIdInOrDirectorsIdIn(List<String> workersIds);
	List<FilmDTO> findByCategoriesIdIn(List<String> categoriesIds);
	FilmDTO findByEAN(String EAN);
	List<FilmDTO> findByNameContaining(String name);
	
	List<FilmDTO> findByActorsIdInAndCategoriesIdInOrDirectorsInAndCategoriesIn(List<String> workersIds, List<String> categoriesIds);
	List<FilmDTO> findByCategoriesIdInAndNameContaining(List<String> categoriesIds, String name);
	List<FilmDTO> findByReleaseDateBetween(LocalDate startDate, LocalDate endDate);

	List<FilmDTO> findByCategoriesIdInAndReleaseDateBetween(List<String> categoriesIds, LocalDate startDate, LocalDate endDate);
	List<FilmDTO> findByNameContainingAndReleaseDateBetween(String name, LocalDate startDate, LocalDate endDate);
	
	List<FilmDTO> findByCategoriesIdInAndNameContainingAndReleaseDateBetween(List<String> categoriesIds, String name, LocalDate startDate, LocalDate endDate);
}
