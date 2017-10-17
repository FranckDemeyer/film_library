package st.fr.fdclick.back.films.services.implementations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import st.fr.fdclick.back.films.dtos.FilmWorkerDTO;
import st.fr.fdclick.back.films.entities.FilmWorker;
import st.fr.fdclick.back.films.repositories.FilmWorkerRepository;
import st.fr.fdclick.back.films.services.interfaces.IFilmWorkerService;

@Service("filmWorkerService")
public class FilmWorkerService implements IFilmWorkerService {
	
	@Autowired
	private FilmWorkerRepository filmWorkerRepository;
	
	private FilmWorker FilmWorkerDTOToFilmWorker(FilmWorkerDTO filmWorkerDTO) {
		FilmWorker filmWorker = new FilmWorker();
		BeanUtils.copyProperties(filmWorkerDTO, filmWorker);
		return filmWorker;
	}
	
	private FilmWorkerDTO FilmWorkerToFilmWorkerDTO(FilmWorker filmWorker) {
		FilmWorkerDTO filmWorkerDTO = new FilmWorkerDTO();
		BeanUtils.copyProperties(filmWorker, filmWorkerDTO);
		return filmWorkerDTO;
	}

	@Override
	public FilmWorkerDTO addOrUpdate(FilmWorkerDTO filmWorkerDTO) {
		return FilmWorkerToFilmWorkerDTO(filmWorkerRepository.save(FilmWorkerDTOToFilmWorker(filmWorkerDTO)));
	}

	@Override
	public void deleteById(String id) {
		filmWorkerRepository.delete(id);
	}

	@Override
	public List<FilmWorkerDTO> findAll() {
		List<FilmWorkerDTO> FilmWorkersDTOs = new ArrayList<>();
		List<FilmWorker> filmWorkers = filmWorkerRepository.findAll();
		if(filmWorkers != null) for(FilmWorker filmWorker: filmWorkers) FilmWorkersDTOs.add(FilmWorkerToFilmWorkerDTO(filmWorker));
		return FilmWorkersDTOs;
	}

	@Override
	public FilmWorkerDTO findById(String id) {
		FilmWorker filmWorker = filmWorkerRepository.findOne(id);
		if(filmWorker != null) return FilmWorkerToFilmWorkerDTO(filmWorker);
		return new FilmWorkerDTO();
	}

	@Override
	public List<FilmWorkerDTO> findByFirstNameContaining(String firstName) {
		List<FilmWorkerDTO> FilmWorkersDTOs = new ArrayList<>();
		List<FilmWorker> filmWorkers = filmWorkerRepository.findByFirstNameContaining(firstName);
		if(filmWorkers != null) for(FilmWorker filmWorker: filmWorkers) FilmWorkersDTOs.add(FilmWorkerToFilmWorkerDTO(filmWorker));
		return FilmWorkersDTOs;
	}

	@Override
	public List<FilmWorkerDTO> findByLastNameContaining(String lastName) {
		List<FilmWorkerDTO> FilmWorkersDTOs = new ArrayList<>();
		List<FilmWorker> filmWorkers = filmWorkerRepository.findByLastNameContaining(lastName);
		if(filmWorkers != null) for(FilmWorker filmWorker: filmWorkers) FilmWorkersDTOs.add(FilmWorkerToFilmWorkerDTO(filmWorker));
		return FilmWorkersDTOs;
	}

	@Override
	public List<FilmWorkerDTO> findByBirthDateBetween(LocalDate startBirthDate, LocalDate endBirthDate) {
		List<FilmWorkerDTO> FilmWorkersDTOs = new ArrayList<>();
		List<FilmWorker> filmWorkers = filmWorkerRepository.findByBirthDateBetween(startBirthDate, endBirthDate);
		if(filmWorkers != null) for(FilmWorker filmWorker: filmWorkers) FilmWorkersDTOs.add(FilmWorkerToFilmWorkerDTO(filmWorker));
		return FilmWorkersDTOs;
	}

	@Override
	public List<FilmWorkerDTO> findByFirstNameContainingAndLastNameContaining(String firstName, String lastName) {
		List<FilmWorkerDTO> FilmWorkersDTOs = new ArrayList<>();
		List<FilmWorker> filmWorkers = filmWorkerRepository.findByFirstNameContainingAndLastNameContaining(firstName, lastName);
		if(filmWorkers != null) for(FilmWorker filmWorker: filmWorkers) FilmWorkersDTOs.add(FilmWorkerToFilmWorkerDTO(filmWorker));
		return FilmWorkersDTOs;
	}

	@Override
	public List<FilmWorkerDTO> findByBirthDateBetweenAndFirstNameContaining(LocalDate startBirthDate,
			LocalDate endBirthDate, String firstName) {
		List<FilmWorkerDTO> FilmWorkersDTOs = new ArrayList<>();
		List<FilmWorker> filmWorkers = filmWorkerRepository.findByBirthDateBetweenAndFirstNameContaining(startBirthDate, endBirthDate, firstName);
		if(filmWorkers != null) for(FilmWorker filmWorker: filmWorkers) FilmWorkersDTOs.add(FilmWorkerToFilmWorkerDTO(filmWorker));
		return FilmWorkersDTOs;
	}

	@Override
	public List<FilmWorkerDTO> findByBirthDateBetweenAndLastNameContaining(LocalDate startBirthDate,
			LocalDate endBirthDate, String lastName) {
		List<FilmWorkerDTO> FilmWorkersDTOs = new ArrayList<>();
		List<FilmWorker> filmWorkers = filmWorkerRepository.findByBirthDateBetweenAndLastNameContaining(startBirthDate, endBirthDate, lastName);
		if(filmWorkers != null) for(FilmWorker filmWorker: filmWorkers) FilmWorkersDTOs.add(FilmWorkerToFilmWorkerDTO(filmWorker));
		return FilmWorkersDTOs;
	}

	@Override
	public List<FilmWorkerDTO> findByBirthDateBetweenAndFirstNameContainingAndLastNameContaining(
			LocalDate startBirthDate, LocalDate endBirthDate, String firstName, String lastName) {
		List<FilmWorkerDTO> FilmWorkersDTOs = new ArrayList<>();
		List<FilmWorker> filmWorkers = filmWorkerRepository.findByBirthDateBetweenAndFirstNameContainingAndLastNameContaining(startBirthDate, endBirthDate, firstName, lastName);
		if(filmWorkers != null) for(FilmWorker filmWorker: filmWorkers) FilmWorkersDTOs.add(FilmWorkerToFilmWorkerDTO(filmWorker));
		return FilmWorkersDTOs;
	}

}
