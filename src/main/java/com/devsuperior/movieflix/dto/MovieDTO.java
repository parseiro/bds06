package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class MovieDTO implements Serializable {
    private static final long serialVersionUID = 7033194677266153797L;

    private Long id;
    private String title;
    private String subTitle;
    private Integer year;
    private String imgUrl;
    private String synopsis;
    private GenreDTO genre;
    private Set<ReviewDTO> reviews = new HashSet<>();

    public MovieDTO() {
    }

    public MovieDTO(Movie entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.subTitle = entity.getSubTitle();
        this.year = entity.getYear();
        this.imgUrl = entity.getImgUrl();
        this.synopsis = entity.getSynopsis();
        this.genre = new GenreDTO(entity.getGenre());
    }

    public MovieDTO(Movie entity, Set<Review> reviews) {
        this(entity);
        reviews.forEach(r -> this.reviews.add(new ReviewDTO(r)));
    }
}
