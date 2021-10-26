package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class GenreDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    private Collection<MovieDTO> movies = new ArrayList<>();

    public GenreDTO() {
    }

    public GenreDTO(Genre entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public GenreDTO(Genre entity, Collection<Movie> movies) {
        this(entity);
        movies.forEach(m -> this.movies.add(new MovieDTO(m)));
    }
}
