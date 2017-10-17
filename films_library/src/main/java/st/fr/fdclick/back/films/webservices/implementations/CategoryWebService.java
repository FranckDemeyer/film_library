package st.fr.fdclick.back.films.webservices.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import st.fr.fdclick.back.films.dtos.CategoryDTO;
import st.fr.fdclick.back.films.services.interfaces.ICategoryService;
import st.fr.fdclick.back.films.webservices.interfaces.ICategoryWebService;

@RestController
@RequestMapping("categories")
@CrossOrigin(origins="*")
public class CategoryWebService implements ICategoryWebService {
	
	@Autowired
	private ICategoryService categoryService;

	@RequestMapping(value="/save", method=RequestMethod.POST)
	@Override
	public ResponseEntity<CategoryDTO> add(@RequestBody CategoryDTO categoryDTO) {
		return new ResponseEntity<CategoryDTO>(categoryService.addOrUpdate(categoryDTO), HttpStatus.OK);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	@Override
	public ResponseEntity<CategoryDTO> update(@RequestBody CategoryDTO categoryDTO) {
		return new ResponseEntity<CategoryDTO>(categoryService.addOrUpdate(categoryDTO), HttpStatus.OK);
	}

	@RequestMapping(value="/del/{id}", method=RequestMethod.DELETE)
	@Override
	public void deleteById(@PathVariable("id") String id) {
		categoryService.deleteById(id);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method=RequestMethod.GET)
	@Override
	public ResponseEntity<List<CategoryDTO>> findAll() {
		List<CategoryDTO> categoriesDTOs = categoryService.findAll();
		if(categoriesDTOs.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<CategoryDTO>>(categoriesDTOs, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@Override
	public ResponseEntity<CategoryDTO> findById(@PathVariable("id") String id) {
		CategoryDTO categoryDTO = categoryService.findById(id);
		if(categoryDTO.getId() == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity<CategoryDTO>(categoryDTO, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/name/{name}", method=RequestMethod.GET)
	@Override
	public ResponseEntity<List<CategoryDTO>> findByNameContaining(@PathVariable("name") String name) {
		List<CategoryDTO> categoriesDTOs = categoryService.findByNameContaining(name);
		if(categoriesDTOs.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<CategoryDTO>>(categoriesDTOs, HttpStatus.OK);
	}

}
