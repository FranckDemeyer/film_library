package st.fr.fdclick.back.films.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import st.fr.fdclick.back.films.entities.Film;

public interface FilmRepository extends MongoRepository<Film, String> {
	List<Film> findByCategoriesIdIn(List<String> categoriesIds);
	Film findByEAN(String EAN);
	List<Film> findByNameContaining(String name);
	
	List<Film> findByActorsIdInOrDirectorsIdIn(List<String> actorsIds, List<String> directorsIds);
	List<Film> findByCategoriesIdInAndNameContaining(List<String> categoriesIds, String name);
	List<Film> findByReleaseDateBetween(LocalDate startDate, LocalDate endDate);

	List<Film> findByCategoriesIdInAndReleaseDateBetween(List<String> categoriesIds, LocalDate startDate, LocalDate endDate);
	List<Film> findByNameContainingAndReleaseDateBetween(String name, LocalDate startDate, LocalDate endDate);
	
	List<Film> findByActorsIdInAndCategoriesIdInOrDirectorsInAndCategoriesIn(List<String> actorsIds, List<String> categoriesIds1, List<String> directorsIds, List<String> categoriesIds2);
	List<Film> findByCategoriesIdInAndNameContainingAndReleaseDateBetween(List<String> categoriesIds, String name, LocalDate startDate, LocalDate endDate);
}
