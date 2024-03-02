package com.se.movie.simple.domain.service;

import java.util.List;

import com.se.movie.simple.domain.entity.MovieGenre;
import com.se.movie.simple.domain.payload.request.GetInternalApiRequest;

public interface MovieGenreService {

	List<String> save(List<MovieGenre> records) throws Exception;

	List<MovieGenre> getMovieGenre(GetInternalApiRequest request) throws Exception;

}
