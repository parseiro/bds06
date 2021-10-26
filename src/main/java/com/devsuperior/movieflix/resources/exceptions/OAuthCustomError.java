package com.devsuperior.movieflix.resources.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class OAuthCustomError implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String error;

    @JsonProperty("error_description")
    @Getter @Setter
    private String errorDescription;


}
