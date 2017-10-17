package st.fr.fdclick.back.films.img.dtos;

import java.io.Serializable;

public class ImageDTO implements Serializable {
	
	/* Variables */

	private static final long serialVersionUID = -2134405275530750828L;
	private String name;
	private String image;
	private String type;
	
	/* Constructors */
	
	public ImageDTO() {}

	public ImageDTO(String name, String image, String type) {
		this.name = name;
		this.image = image;
		this.type = type;
	}

	/* Getters and Setters */
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/* Methods */
	
	@Override
	public String toString() {
		return "ImageDTO [name=" + name + ", image=" + image + ", type=" + type + "]";
	}
	
}
