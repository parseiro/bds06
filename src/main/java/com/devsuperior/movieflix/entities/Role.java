package com.devsuperior.movieflix.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tb_role")
public class Role implements Serializable {

    private static final long serialVersionUID = -9052862693343578967L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String authority;
}
