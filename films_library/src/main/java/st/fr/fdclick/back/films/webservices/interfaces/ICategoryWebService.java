package st.fr.fdclick.back.films.webservices.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import st.fr.fdclick.back.films.dtos.CategoryDTO;

public interface ICategoryWebService {
	ResponseEntity<CategoryDTO> add(CategoryDTO categoryDTO);
	ResponseEntity<CategoryDTO> update(CategoryDTO categoryDTO);
	void deleteById(String id);
	ResponseEntity<List<CategoryDTO>> findAll();
	ResponseEntity<CategoryDTO> findById(String id);
	
	ResponseEntity<List<CategoryDTO>> findByNameContaining(String name);
}
