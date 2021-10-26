package com.devsuperior.movieflix.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tb_review")
public class Review implements Serializable {
    private static final long serialVersionUID = -959937491437543679L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String text;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @Getter
    @Setter
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Getter
    @Setter
    private User user;
}
