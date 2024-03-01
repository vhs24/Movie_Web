package com.se.movie.simple.domain.common;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.se.movie.simple.domain.payload.response.InternalApiResponse;

public class GeneratorCommonUtil {

	public static String getResponseBodySuccess(Object data) {
		InternalApiResponse response = new InternalApiResponse();
		response.setData(data);
		response.setStatus(1);
		response.setErrors(List.of());
		
		return ObjectMapperCommonUtil.writeValueAsString(response);
	}
	
	public static String getResponseBodyError(List<String> errors) {
		InternalApiResponse response = new InternalApiResponse();
		response.setData(null);
		response.setStatus(1);
		response.setErrors(errors);
		
		return ObjectMapperCommonUtil.writeValueAsString(response);
	}
	
}
