package st.fr.fdclick.back.films.services.interfaces;

import java.util.List;

import st.fr.fdclick.back.films.dtos.CategoryDTO;

public interface ICategoryService {
	CategoryDTO addOrUpdate(CategoryDTO categoryDTO);
	void deleteById(String id);
	List<CategoryDTO> findAll();
	CategoryDTO findById(String id);
	
	List<CategoryDTO> findByNameContaining(String name);
}
