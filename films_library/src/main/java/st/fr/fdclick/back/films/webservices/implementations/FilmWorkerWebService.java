package st.fr.fdclick.back.films.webservices.implementations;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import st.fr.fdclick.back.films.dtos.FilmWorkerDTO;
import st.fr.fdclick.back.films.services.interfaces.IFilmWorkerService;
import st.fr.fdclick.back.films.webservices.interfaces.IFilmWorkerWebService;

@RestController
@RequestMapping("filmworkers")
@CrossOrigin(origins="*")
public class FilmWorkerWebService implements IFilmWorkerWebService {
	
	@Autowired
	private IFilmWorkerService filmWorkerService;

	@RequestMapping(value="/save", method=RequestMethod.POST)
	@Override
	public ResponseEntity<FilmWorkerDTO> add(FilmWorkerDTO filmWorkerDTO) {
		return new ResponseEntity<FilmWorkerDTO>(filmWorkerService.addOrUpdate(filmWorkerDTO), HttpStatus.OK);
	}

	@RequestMapping(value="/update", method=RequestMethod.PUT)
	@Override
	public ResponseEntity<FilmWorkerDTO> update(FilmWorkerDTO filmWorkerDTO) {
		return new ResponseEntity<FilmWorkerDTO>(filmWorkerService.addOrUpdate(filmWorkerDTO), HttpStatus.OK);
	}

	@RequestMapping(value="/del/{id}", method=RequestMethod.DELETE)
	@Override
	public void deleteById(@PathVariable("id") String id) {
		filmWorkerService.deleteById(id);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method=RequestMethod.GET)
	@Override
	public ResponseEntity<List<FilmWorkerDTO>> findAll() {
		List<FilmWorkerDTO> filmWorkersDTOs = filmWorkerService.findAll();
		if(filmWorkersDTOs.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<FilmWorkerDTO>>(filmWorkersDTOs, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@Override
	public ResponseEntity<FilmWorkerDTO> findById(@PathVariable("id") String id) {
		FilmWorkerDTO filmWorkerDTO = filmWorkerService.findById(id);
		if(filmWorkerDTO.getId() == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity<FilmWorkerDTO>(filmWorkerDTO, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/firstname={name}", method=RequestMethod.GET)
	@Override
	public ResponseEntity<List<FilmWorkerDTO>> findByFirstNameContaining(@PathVariable("name") String firstName) {
		List<FilmWorkerDTO> filmWorkersDTOs = filmWorkerService.findByFirstNameContaining(firstName);
		if(filmWorkersDTOs.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<FilmWorkerDTO>>(filmWorkersDTOs, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/lastname={name}", method=RequestMethod.GET)
	@Override
	public ResponseEntity<List<FilmWorkerDTO>> findByLastNameContaining(@PathVariable("name") String lastName) {
		List<FilmWorkerDTO> filmWorkersDTOs = filmWorkerService.findByLastNameContaining(lastName);
		if(filmWorkersDTOs.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<FilmWorkerDTO>>(filmWorkersDTOs, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/startdate={stardate}/enddate={enddate}", method=RequestMethod.GET)
	@Override
	public ResponseEntity<List<FilmWorkerDTO>> findByBirthDateBetween(@PathVariable("startdate") LocalDate startBirthDate,
			@PathVariable("enddate") LocalDate endBirthDate) {
		List<FilmWorkerDTO> filmWorkersDTOs = filmWorkerService.findByBirthDateBetween(startBirthDate, endBirthDate);
		if(filmWorkersDTOs.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<FilmWorkerDTO>>(filmWorkersDTOs, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/firstname={fname}/lastname={lname}", method=RequestMethod.GET)
	@Override
	public ResponseEntity<List<FilmWorkerDTO>> findByFirstNameContainingAndLastNameContaining(@PathVariable("fname") String firstName,
			@PathVariable("lname") String lastName) {
		List<FilmWorkerDTO> filmWorkersDTOs = filmWorkerService.findByFirstNameContainingAndLastNameContaining(firstName, lastName);
		if(filmWorkersDTOs.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<FilmWorkerDTO>>(filmWorkersDTOs, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/stardate={startdate}/enddate={enddate}/firstname={name}", method=RequestMethod.GET)
	@Override
	public ResponseEntity<List<FilmWorkerDTO>> findByBirthDateBetweenAndFirstNameContaining(@PathVariable("startdate") LocalDate startBirthDate,
			@PathVariable("enddate") LocalDate endBirthDate, @PathVariable("name") String firstName) {
		List<FilmWorkerDTO> filmWorkersDTOs = filmWorkerService.findByBirthDateBetweenAndFirstNameContaining(startBirthDate, endBirthDate, firstName);
		if(filmWorkersDTOs.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<FilmWorkerDTO>>(filmWorkersDTOs, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/stardate={startdate}/enddate={enddate}/lastname={name}", method=RequestMethod.GET)
	@Override
	public ResponseEntity<List<FilmWorkerDTO>> findByBirthDateBetweenAndLastNameContaining(@PathVariable("startdate") LocalDate startBirthDate,
			@PathVariable("enddate") LocalDate endBirthDate, @PathVariable("name") String lastName) {
		List<FilmWorkerDTO> filmWorkersDTOs = filmWorkerService.findByBirthDateBetweenAndLastNameContaining(startBirthDate, endBirthDate, lastName);
		if(filmWorkersDTOs.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<FilmWorkerDTO>>(filmWorkersDTOs, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/stardate={startdate}/enddate={enddate}/firstname={fname}/lastname={lname}", method=RequestMethod.GET)
	@Override
	public ResponseEntity<List<FilmWorkerDTO>> findByBirthDateBetweenAndFirstNameContainingAndLastNameContaining(
			@PathVariable("startdate") LocalDate startBirthDate, @PathVariable("enddate") LocalDate endBirthDate,
			@PathVariable("fname") String firstName, @PathVariable("lname") String lastName) {
		List<FilmWorkerDTO> filmWorkersDTOs = filmWorkerService.findByBirthDateBetweenAndFirstNameContainingAndLastNameContaining(startBirthDate, endBirthDate, firstName, lastName);
		if(filmWorkersDTOs.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<FilmWorkerDTO>>(filmWorkersDTOs, HttpStatus.OK);
	}

}
