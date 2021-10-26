package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("select distinct obj from Movie obj "
            + "where (COALESCE(:genres) is null or obj.genre IN :genres) "
            + "and (:name is null or lower(obj.title) like CONCAT('%', lower(trim(:name)), '%')) "
            + "order by obj.title"
    )
    Page<Movie> find(List<Genre> genres, String name, Pageable pageable);
}
