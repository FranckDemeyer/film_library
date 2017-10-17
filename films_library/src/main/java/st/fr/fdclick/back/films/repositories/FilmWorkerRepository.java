package st.fr.fdclick.back.films.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import st.fr.fdclick.back.films.entities.FilmWorker;

public interface FilmWorkerRepository extends MongoRepository<FilmWorker, String> {
	List<FilmWorker> findByFirstNameContaining(String firstName);
	List<FilmWorker> findByLastNameContaining(String lastName);
	
	List<FilmWorker> findByBirthDateBetween(LocalDate startBirthDate, LocalDate endBirthDate);
	List<FilmWorker> findByFirstNameContainingAndLastNameContaining(String firstName, String lastName);
	
	List<FilmWorker> findByBirthDateBetweenAndFirstNameContaining(LocalDate startBirthDate, LocalDate endBirthDate, String firstName);
	List<FilmWorker> findByBirthDateBetweenAndLastNameContaining(LocalDate startBirthDate, LocalDate endBirthDate, String lastName);
	
	List<FilmWorker> findByBirthDateBetweenAndFirstNameContainingAndLastNameContaining(LocalDate startBirthDate, LocalDate endBirthDate, String firstName, String lastName);
}
