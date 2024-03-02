package com.se.movie.simple.domain.service;

import java.util.List;

import com.se.movie.simple.domain.entity.MovieTrailer;
import com.se.movie.simple.domain.payload.request.GetInternalApiRequest;

public interface MovieTrailerService {

	List<String> save(List<MovieTrailer> records) throws Exception;

	List<MovieTrailer> getMovieTrailer(GetInternalApiRequest request) throws Exception;

}
