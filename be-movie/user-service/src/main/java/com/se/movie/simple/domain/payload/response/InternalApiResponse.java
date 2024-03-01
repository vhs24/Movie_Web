package com.se.movie.simple.domain.payload.response;

import java.util.List;

import lombok.Data;

@Data
public class InternalApiResponse {

	private Object data;
	private int status;
	private List<String> errors;
}
