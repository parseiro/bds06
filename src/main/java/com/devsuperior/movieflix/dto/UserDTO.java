package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
//@AllArgsConstructor
public class UserDTO implements Serializable {
    private static final long serialVersionUID = -747644125139959727L;

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String email;

    public UserDTO(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
    }
}
