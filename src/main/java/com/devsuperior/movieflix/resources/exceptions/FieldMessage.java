package com.devsuperior.movieflix.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class FieldMessage {
    @Getter
    private String field;

    @Getter
    private String message;
}
