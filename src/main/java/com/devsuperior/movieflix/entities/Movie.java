package com.devsuperior.movieflix.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_movie")
public class Movie implements Serializable {
    private static final long serialVersionUID = 8547505925796247682L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(length = 30)
    @Getter
    @Setter
    private String title;

    @Column(length = 30)
    @Getter
    @Setter
    private String subTitle;

    @Getter
    @Setter
    private Integer year;

    @Getter
    @Setter
    private String imgUrl;

    @Column(length = 2000)
    @Getter
    @Setter
    private String synopsis;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    @Getter
    @Setter
    private Genre genre;

    @OneToMany(mappedBy = "movie")
    @Getter
    private Set<Review> reviews = new HashSet<>();
}
