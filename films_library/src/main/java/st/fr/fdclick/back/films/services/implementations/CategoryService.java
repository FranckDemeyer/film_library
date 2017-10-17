package st.fr.fdclick.back.films.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import st.fr.fdclick.back.films.dtos.CategoryDTO;
import st.fr.fdclick.back.films.entities.Category;
import st.fr.fdclick.back.films.repositories.CategoryRepository;
import st.fr.fdclick.back.films.services.interfaces.ICategoryService;

@Service("categoryService")
public class CategoryService implements ICategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	private Category CategoryDTOToCategory(CategoryDTO categoryDTO) {
		Category category = new Category();
		BeanUtils.copyProperties(categoryDTO, category);
		return category;
	}
	
	private CategoryDTO CategoryToCategoryDTO(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO();
		BeanUtils.copyProperties(category, categoryDTO);
		return categoryDTO;
	}

	@Override
	public CategoryDTO addOrUpdate(CategoryDTO categoryDTO) {
		return CategoryToCategoryDTO(categoryRepository.save(CategoryDTOToCategory(categoryDTO)));
	}

	@Override
	public void deleteById(String id) {
		categoryRepository.delete(id);
	}

	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryDTO> categoriesDTOs = new ArrayList<>();
		List<Category> categories = categoryRepository.findAll();
		if(categories != null) for(Category category: categories) categoriesDTOs.add(CategoryToCategoryDTO(category));
		return categoriesDTOs;
	}

	@Override
	public CategoryDTO findById(String id) {
		Category category = categoryRepository.findOne(id);
		if(category != null) return CategoryToCategoryDTO(category);
		return new CategoryDTO();
	}

	@Override
	public List<CategoryDTO> findByNameContaining(String name) {
		List<CategoryDTO> categoriesDTOs = new ArrayList<>();
		List<Category> categories = categoryRepository.findByNameContaining(name);
		if(categories != null) for(Category category: categories) categoriesDTOs.add(CategoryToCategoryDTO(category));
		return categoriesDTOs;
	}

}
