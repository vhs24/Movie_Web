package com.se.movie.simple.domain.payload.request;

import jakarta.validation.Valid;
import lombok.Getter;

@Getter
public class ExternalApiRequest<T> {

    @Valid
    private T input;
}
