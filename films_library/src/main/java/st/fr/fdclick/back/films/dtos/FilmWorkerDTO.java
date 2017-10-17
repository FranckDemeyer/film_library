package st.fr.fdclick.back.films.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FilmWorkerDTO implements Serializable {
	
	/* Variables */

	private static final long serialVersionUID = 1983230540968754111L;
	private String id;
	private String firstName;
	private String lastName;
	@DateTimeFormat(iso=ISO.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate birthDate;

	/* Constructors */
	
	public FilmWorkerDTO() {}

	public FilmWorkerDTO(String firstName, String lastName, LocalDate birthDate) {
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
		return "FilmWorkerDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate="
				+ birthDate + "]";
	}
	
}
