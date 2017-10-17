package st.fr.fdclick.back.films.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="films")
public class Film {
	
	/* Variables */
	
	@Id
	private String id;
	private String name;
	private String EAN;
	private LocalDate releaseDate;
	private Duration filmDuration;
	private String poster;
	private String synopsis;
	private List<Category> categories;
	private List<FilmWorker> actors;
	private List<FilmWorker> directors;
	
	/* Constructors */
	
	public Film() {}

	public Film(String name, String EAN, LocalDate releaseDate, Duration filmDuration, String poster, String synopsis,
			List<Category> categories, List<FilmWorker> actors, List<FilmWorker> directors) {
		super();
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

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<FilmWorker> getActors() {
		return actors;
	}

	public void setActors(List<FilmWorker> actors) {
		this.actors = actors;
	}

	public List<FilmWorker> getDirectors() {
		return directors;
	}

	public void setDirectors(List<FilmWorker> directors) {
		this.directors = directors;
	}
	
	/* Methods */
	
	@Override
	public String toString() {
		return "Film [id=" + id + ", name=" + name + ", EAN=" + EAN + ", releaseDate=" + releaseDate + ", filmDuration="
				+ filmDuration + ", poster=" + poster + ", synopsis=" + synopsis + ", categories=" + categories
				+ ", actors=" + actors + ", directors=" + directors + "]";
	}

}
