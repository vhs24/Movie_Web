package com.se.movie.simple.domain.service;

import java.util.List;

import com.se.movie.simple.domain.entity.GenreType;
import com.se.movie.simple.domain.payload.request.GetInternalApiRequest;

public interface GenreTypeService {

	List<String> save(List<GenreType> records) throws Exception;

	List<GenreType> getGenreType(GetInternalApiRequest request) throws Exception;

}
