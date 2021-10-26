package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public List<ReviewDTO> reviewsByMovieId(Long movieId) {
        return reviewRepository.findAllByMovieId(movieId);
    }

    @Transactional
    public ReviewDTO insert(ReviewDTO dto) {
        User currentUser = authService.authenticated();
        dto.setUser(new UserDTO(currentUser));

        var entity = new Review();
        copyDtoToEntity(dto, entity);
        entity = reviewRepository.save(entity);
        return new ReviewDTO(entity);
    }

    private void copyDtoToEntity(ReviewDTO dto, Review entity) {

        entity.setId(dto.getId());
        entity.setText(dto.getText());

        Movie movie = movieRepository.getOne(dto.getMovieId());
        entity.setMovie(movie);


        Long userId = dto.getUser().getId();
        if (userId != null) {
            User user = userRepository.getOne(userId);
            entity.setUser(user);
        }
    }

}
