package st.fr.fdclick.back.films.services.implementations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import st.fr.fdclick.back.films.dtos.CategoryDTO;
import st.fr.fdclick.back.films.dtos.FilmDTO;
import st.fr.fdclick.back.films.dtos.FilmWorkerDTO;
import st.fr.fdclick.back.films.entities.Category;
import st.fr.fdclick.back.films.entities.Film;
import st.fr.fdclick.back.films.entities.FilmWorker;
import st.fr.fdclick.back.films.repositories.FilmRepository;
import st.fr.fdclick.back.films.services.interfaces.IFilmService;

@Service("filmService")
public class FilmService implements IFilmService {
	
	@Autowired
	private FilmRepository filmRepository;
	
	private Film FilmDTOToFilm(FilmDTO filmDTO) {
		Film film = new Film();
		BeanUtils.copyProperties(filmDTO, film);
		// Adding uncaught properties due to DTOs
		List<Category> categories = new ArrayList<>();
		for(CategoryDTO categoryDTO: filmDTO.getCategories()) {
			Category category = new Category();
			BeanUtils.copyProperties(categoryDTO, category);
			categories.add(category);
		}
		film.setCategories(categories);
		List<FilmWorker> actors = new ArrayList<>();
		for(FilmWorkerDTO actorDTO: filmDTO.getActors()) {
			FilmWorker actor = new FilmWorker();
			BeanUtils.copyProperties(actorDTO, actor);
			actors.add(actor);
		}
		film.setActors(actors);
		List<FilmWorker> directors = new ArrayList<>();
		for(FilmWorkerDTO directorDTO: filmDTO.getDirectors()) {
			FilmWorker director = new FilmWorker();
			BeanUtils.copyProperties(directorDTO, director);
			directors.add(director);
		}
		film.setDirectors(directors);
		return film;
	}
	
	private FilmDTO FilmToFilmDTO(Film film) {
		FilmDTO filmDTO = new FilmDTO();
		BeanUtils.copyProperties(film, filmDTO);
		// adding uncaught properties due to DTOs
		List<CategoryDTO> categoriesDTOs = new ArrayList<>();
		for(Category category: film.getCategories()) {
			CategoryDTO categoryDTO = new CategoryDTO();
			BeanUtils.copyProperties(category, categoryDTO);
			categoriesDTOs.add(categoryDTO);
		}
		filmDTO.setCategories(categoriesDTOs);
		List<FilmWorkerDTO> actorsDTOs = new ArrayList<>();
		for(FilmWorker actor: film.getActors()) {
			FilmWorkerDTO actorDTO = new FilmWorkerDTO();
			BeanUtils.copyProperties(actor, actorDTO);
			actorsDTOs.add(actorDTO);
		}
		filmDTO.setActors(actorsDTOs);
		List<FilmWorkerDTO> directorsDTOs = new ArrayList<>();
		for(FilmWorker director: film.getDirectors()) {
			FilmWorkerDTO directorDTO = new FilmWorkerDTO();
			BeanUtils.copyProperties(director, directorDTO);
			directorsDTOs.add(directorDTO);
		}
		filmDTO.setDirectors(directorsDTOs);
		return filmDTO;
	}

	@Override
	public FilmDTO addOrUpdate(FilmDTO filmDTO) {
		return FilmToFilmDTO(filmRepository.save(FilmDTOToFilm(filmDTO)));
	}

	@Override
	public void deleteById(String id) {
		filmRepository.delete(id);
	}

	@Override
	public List<FilmDTO> findAll() {
		List<FilmDTO> filmsDTOs = new ArrayList<>();
		List<Film> films = filmRepository.findAll();
		if(films != null) for(Film film: films) filmsDTOs.add(FilmToFilmDTO(film));
		return filmsDTOs;
	}

	@Override
	public FilmDTO findById(String id) {
		Film film = filmRepository.findOne(id);
		if(film != null) return FilmToFilmDTO(film);
		return new FilmDTO();
	}

	@Override
	public List<FilmDTO> findByActorsIdInOrDirectorsIdIn(List<String> workersIds) {
		List<FilmDTO> filmsDTOs = new ArrayList<>();
		List<Film> films = filmRepository.findByActorsIdInOrDirectorsIdIn(workersIds, workersIds);
		if(films != null) for(Film film: films) filmsDTOs.add(FilmToFilmDTO(film));
		return filmsDTOs;
	}

	@Override
	public List<FilmDTO> findByCategoriesIdIn(List<String> categoriesIds) {
		List<FilmDTO> filmsDTOs = new ArrayList<>();
		List<Film> films = filmRepository.findByCategoriesIdIn(categoriesIds);
		if(films != null) for(Film film: films) filmsDTOs.add(FilmToFilmDTO(film));
		return filmsDTOs;
	}

	@Override
	public FilmDTO findByEAN(String EAN) {
		Film film = filmRepository.findByEAN(EAN);
		if(film != null) return FilmToFilmDTO(film);
		return new FilmDTO();
	}

	@Override
	public List<FilmDTO> findByNameContaining(String name) {
		List<FilmDTO> filmsDTOs = new ArrayList<>();
		List<Film> films = filmRepository.findByNameContaining(name);
		if(films != null) for(Film film: films) filmsDTOs.add(FilmToFilmDTO(film));
		return filmsDTOs;
	}

	@Override
	public List<FilmDTO> findByActorsIdInAndCategoriesIdInOrDirectorsInAndCategoriesIn(List<String> workersIds, List<String> categoriesIds) {
		List<FilmDTO> filmsDTOs = new ArrayList<>();
		List<Film> films = filmRepository.findByActorsIdInAndCategoriesIdInOrDirectorsInAndCategoriesIn(workersIds, categoriesIds, workersIds, categoriesIds);
		if(films != null) for(Film film: films) filmsDTOs.add(FilmToFilmDTO(film));
		return filmsDTOs;
	}

	@Override
	public List<FilmDTO> findByCategoriesIdInAndNameContaining(List<String> categoriesIds, String name) {
		List<FilmDTO> filmsDTOs = new ArrayList<>();
		List<Film> films = filmRepository.findByCategoriesIdInAndNameContaining(categoriesIds, name);
		if(films != null) for(Film film: films) filmsDTOs.add(FilmToFilmDTO(film));
		return filmsDTOs;
	}

	@Override
	public List<FilmDTO> findByReleaseDateBetween(LocalDate startDate, LocalDate endDate) {
		List<FilmDTO> filmsDTOs = new ArrayList<>();
		List<Film> films = filmRepository.findByReleaseDateBetween(startDate, endDate);
		if(films != null) for(Film film: films) filmsDTOs.add(FilmToFilmDTO(film));
		return filmsDTOs;
	}

	@Override
	public List<FilmDTO> findByCategoriesIdInAndReleaseDateBetween(List<String> categoriesIds, LocalDate startDate,
			LocalDate endDate) {
		List<FilmDTO> filmsDTOs = new ArrayList<>();
		List<Film> films = filmRepository.findByCategoriesIdInAndReleaseDateBetween(categoriesIds, startDate, endDate);
		if(films != null) for(Film film: films) filmsDTOs.add(FilmToFilmDTO(film));
		return filmsDTOs;
	}

	@Override
	public List<FilmDTO> findByNameContainingAndReleaseDateBetween(String name, LocalDate startDate,
			LocalDate endDate) {
		List<FilmDTO> filmsDTOs = new ArrayList<>();
		List<Film> films = filmRepository.findByNameContainingAndReleaseDateBetween(name, startDate, endDate);
		if(films != null) for(Film film: films) filmsDTOs.add(FilmToFilmDTO(film));
		return filmsDTOs;
	}

	@Override
	public List<FilmDTO> findByCategoriesIdInAndNameContainingAndReleaseDateBetween(List<String> categoriesIds,
			String name, LocalDate startDate, LocalDate endDate) {
		List<FilmDTO> filmsDTOs = new ArrayList<>();
		List<Film> films = filmRepository.findByCategoriesIdInAndNameContainingAndReleaseDateBetween(categoriesIds, name, startDate, endDate);
		if(films != null) for(Film film: films) filmsDTOs.add(FilmToFilmDTO(film));
		return filmsDTOs;
	}

}
