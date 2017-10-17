package st.fr.fdclick.back.films.entities;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="film_workers")
public class FilmWorker {
	
	/* Variables */
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	
	/* Constructors */
	
	public FilmWorker() {}

	public FilmWorker(String firstName, String lastName, LocalDate birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}
	
	/* Getters and Setters */
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	/* Methods */
	
	@Override
	public String toString() {
		return "FilmWorker [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate="
				+ birthDate + "]";
	}

}
