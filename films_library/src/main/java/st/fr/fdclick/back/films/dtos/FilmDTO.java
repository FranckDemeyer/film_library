package st.fr.fdclick.back.films.dtos;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class FilmDTO implements Serializable{
	
	/* Variables */

	private static final long serialVersionUID = 2151292345094870467L;
	private String id;
	private String name;
	private String EAN;
	private LocalDate releaseDate;
	private Duration filmDuration;
	private String poster;
	private String synopsis;
	private List<CategoryDTO> categories;
	private List<FilmWorkerDTO> actors;
	private List<FilmWorkerDTO> directors;
	
	/* Constructors */
	
	public FilmDTO() {}

	public FilmDTO(String name, String EAN, LocalDate releaseDate, Duration filmDuration, String poster,
			String synopsis, List<CategoryDTO> categories, List<FilmWorkerDTO> actors, List<FilmWorkerDTO> directors) {
		this.name = name;
		this.EAN = EAN;
		this.releaseDate = releaseDate;
		this.filmDuration = filmDuration;
		this.poster = poster;
		this.synopsis = synopsis;
		this.categories = categories;
		this.actors = actors;
		this.directors = directors;
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

	public String getEAN() {
		return EAN;
	}

	public void setEAN(String EAN) {
		this.EAN = EAN;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Duration getFilmDuration() {
		return filmDuration;
	}

	public void setFilmDuration(Duration filmDuration) {
		this.filmDuration = filmDuration;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryDTO> categories) {
		this.categories = categories;
	}

	public List<FilmWorkerDTO> getActors() {
		return actors;
	}

	public void setActors(List<FilmWorkerDTO> actors) {
		this.actors = actors;
	}

	public List<FilmWorkerDTO> getDirectors() {
		return directors;
	}

	public void setDirectors(List<FilmWorkerDTO> directors) {
		this.directors = directors;
	}
	
	/* Methods */
	
	@Override
	public String toString() {
		return "FilmDTO [id=" + id + ", name=" + name + ", EAN=" + EAN + ", releaseDate=" + releaseDate
				+ ", filmDuration=" + filmDuration + ", poster=" + poster + ", synopsis=" + synopsis + ", categories="
				+ categories + ", actors=" + actors + ", directors=" + directors + "]";
	}
	
}
