package com.se.movie.simple.domain.common;

import java.util.List;

import lombok.Data;

@Data
public class ApiResponseEntity {

	private Object data;
	private int status;
	private List<String> errors;
}
