package st.fr.fdclick.back.films.dtos;

import java.io.Serializable;

public class CategoryDTO implements Serializable {

	/* Variables */

	private static final long serialVersionUID = -3933037396171301479L;
	private String id;
	private String name;
	
	/* Constructors */
	
	public CategoryDTO() {}

	public CategoryDTO(String name) {
		this.name = name;
	}
	
	/* Getters and Setters */
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/* Methods */
	
	@Override
	public String toString() {
		return "CategoryDTO [id=" + id + ", name=" + name + "]";
	}
	
	
}
