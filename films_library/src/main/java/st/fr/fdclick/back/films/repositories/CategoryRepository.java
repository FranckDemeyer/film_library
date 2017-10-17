package st.fr.fdclick.back.films.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import st.fr.fdclick.back.films.entities.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {
	List<Category> findByNameContaining(String name);
}
