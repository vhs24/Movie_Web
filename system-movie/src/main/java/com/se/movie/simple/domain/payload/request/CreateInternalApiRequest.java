package com.se.movie.simple.domain.payload.request;

import java.util.List;

import lombok.Data;

@Data
public class CreateInternalApiRequest<T> {

	private List<T> records;
}
