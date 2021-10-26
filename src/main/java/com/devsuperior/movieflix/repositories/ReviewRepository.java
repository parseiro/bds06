package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByMovie(Movie movie);

    @Query("select new com.devsuperior.movieflix.dto.ReviewDTO(r) from Review r "
            + "where r.movie.id = :movieId")
    List<ReviewDTO> findAllByMovieId(Long movieId);
}
