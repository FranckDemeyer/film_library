package st.fr.fdclick.back.films.webservices.implementations;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;

import st.fr.fdclick.back.films.dtos.FilmDTO;
import st.fr.fdclick.back.films.services.interfaces.IFilmService;
import st.fr.fdclick.back.films.webservices.interfaces.IFilmWebService;

@RestController
@RequestMapping("films")
@CrossOrigin(origins="*")
public class FilmWebService implements IFilmWebService {
	
	@Autowired
	private IFilmService filmService;

	@RequestMapping(value="/save", method=RequestMethod.POST)
	@Override
	public ResponseEntity<FilmDTO> add(@RequestBody FilmDTO filmDTO) {
		return new ResponseEntity<FilmDTO>(filmService.addOrUpdate(filmDTO), HttpStatus.OK);
	}

	@RequestMapping(value="/update", method=RequestMethod.PUT)
	@Override
	public ResponseEntity<FilmDTO> update(@RequestBody FilmDTO filmDTO) {
		return new ResponseEntity<FilmDTO>(filmService.addOrUpdate(filmDTO), HttpStatus.OK);
	}

	@RequestMapping(value="/del/{id}", method=RequestMethod.DELETE)
	@Override
	public void deleteById(@PathVariable("id") String id) {
		filmService.deleteById(id);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method=RequestMethod.GET)
	@Override
	public ResponseEntity<List<FilmDTO>> findAll() {
		List<FilmDTO> filmsDTOs = filmService.findAll();
		if(filmsDTOs.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<FilmDTO>>(filmsDTOs, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@Override
	public ResponseEntity<FilmDTO> findById(@PathVariable("id") String id) {
		FilmDTO filmDTO = filmService.findById(id);
		if(filmDTO.getId() == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity<FilmDTO>(filmDTO, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/workers", method=RequestMethod.GET)
	@Override
	public ResponseEntity<List<FilmDTO>> findByActorsIdInOrDirectorsIdIn(@RequestBody List<String> workersIds) {
		List<FilmDTO> filmsDTOs = filmService.findByActorsIdInOrDirectorsIdIn(workersIds);
		if(filmsDTOs.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<FilmDTO>>(filmsDTOs, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/categories", method=RequestMethod.GET)
	@Override
	public ResponseEntity<List<FilmDTO>> findByCategoriesIdIn(@RequestBody List<String> categoriesIds) {
		List<FilmDTO> filmsDTOs = filmService.findByCategoriesIdIn(categoriesIds);
		if(filmsDTOs.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<FilmDTO>>(filmsDTOs, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/EAN={ean}", method=RequestMethod.GET)
	@Override
	public ResponseEntity<FilmDTO> findByEAN(@PathVariable("ean") String EAN) {
		FilmDTO filmDTO = filmService.findByEAN(EAN);
		if(filmDTO.getId() == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity<FilmDTO>(filmDTO, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/name={name}", method=RequestMethod.GET)
	@Override
	public ResponseEntity<List<FilmDTO>> findByNameContaining(@PathVariable("name") String name) {
		List<FilmDTO> filmsDTOs = filmService.findByNameContaining(name);
		if(filmsDTOs.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<FilmDTO>>(filmsDTOs, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/categories/workers", method=RequestMethod.GET)
	@Override
	public ResponseEntity<List<FilmDTO>> findByActorsIdInAndCategoriesIdInOrDirectorsInAndCategoriesIn(
			@RequestParam("workers") List<String> workersIds, @RequestParam("categories") List<String> categoriesIds) {
		List<FilmDTO> filmsDTOs = filmService.findByActorsIdInAndCategoriesIdInOrDirectorsInAndCategoriesIn(workersIds, categoriesIds);
		if(filmsDTOs.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<FilmDTO>>(filmsDTOs, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/categories/name={name}", method=RequestMethod.GET)
	@Override
	public ResponseEntity<List<FilmDTO>> findByCategoriesIdInAndNameContaining(@RequestBody List<String> categoriesIds,
			@PathVariable("name") String name) {
		List<FilmDTO> filmsDTOs = filmService.findByCategoriesIdInAndNameContaining(categoriesIds, name);
		if(filmsDTOs.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<FilmDTO>>(filmsDTOs, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/startdate={startdate}/enddate={enddate}", method=RequestMethod.GET)
	@Override
	public ResponseEntity<List<FilmDTO>> findByReleaseDateBetween(
			@PathVariable("startdate") @DateTimeFormat(iso=ISO.DATE) @JsonFormat(pattern="yyyy-MM-dd") LocalDate startDate,
			@PathVariable("enddate") @DateTimeFormat(iso=ISO.DATE) @JsonFormat(pattern="yyyy-MM-dd") LocalDate endDate) {
		List<FilmDTO> filmsDTOs = filmService.findByReleaseDateBetween(startDate, endDate);
		if(filmsDTOs.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<FilmDTO>>(filmsDTOs, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/categories/startdate={startdate}/enddate={enddate}", method=RequestMethod.GET)
	@Override
	public ResponseEntity<List<FilmDTO>> findByCategoriesIdInAndReleaseDateBetween(@RequestBody List<String> categoriesIds,
			@PathVariable("startdate") @DateTimeFormat(iso=ISO.DATE) @JsonFormat(pattern="yyyy-MM-dd") LocalDate startDate,
			@PathVariable("enddate") @DateTimeFormat(iso=ISO.DATE) @JsonFormat(pattern="yyyy-MM-dd") LocalDate endDate) {
		List<FilmDTO> filmsDTOs = filmService.findByCategoriesIdInAndReleaseDateBetween(categoriesIds, startDate, endDate);
		if(filmsDTOs.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<FilmDTO>>(filmsDTOs, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/name={name}/startdate={startdate}/enddate={enddate}", method=RequestMethod.GET)
	@Override
	public ResponseEntity<List<FilmDTO>> findByNameContainingAndReleaseDateBetween(@PathVariable("name") String name,
			@PathVariable("startdate") @DateTimeFormat(iso=ISO.DATE) @JsonFormat(pattern="yyyy-MM-dd") LocalDate startDate,
			@PathVariable("enddate") @DateTimeFormat(iso=ISO.DATE) @JsonFormat(pattern="yyyy-MM-dd") LocalDate endDate) {
		List<FilmDTO> filmsDTOs = filmService.findByNameContainingAndReleaseDateBetween(name, startDate, endDate);
		if(filmsDTOs.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<FilmDTO>>(filmsDTOs, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/categories/name={name}/startdate={startdate}/enddate={enddate}", method=RequestMethod.GET)
	@Override
	public ResponseEntity<List<FilmDTO>> findByCategoriesIdInAndNameContainingAndReleaseDateBetween(
			@RequestBody List<String> categoriesIds, @PathVariable("name") String name,
			@PathVariable("startdate") @DateTimeFormat(iso=ISO.DATE) @JsonFormat(pattern="yyyy-MM-dd") LocalDate startDate,
			@PathVariable("enddate") @DateTimeFormat(iso=ISO.DATE) @JsonFormat(pattern="yyyy-MM-dd") LocalDate endDate) {
		List<FilmDTO> filmsDTOs = filmService.findByCategoriesIdInAndNameContainingAndReleaseDateBetween(categoriesIds, name, startDate, endDate);
		if(filmsDTOs.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<FilmDTO>>(filmsDTOs, HttpStatus.OK);
	}

}
