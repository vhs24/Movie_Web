package com.se.movie.simple.domain.service;

import java.util.List;

import com.se.movie.simple.domain.entity.MovieInfo;
import com.se.movie.simple.domain.payload.request.GetInternalApiRequest;

public interface MovieInfoService {

	List<String> save(List<MovieInfo> records) throws Exception;

	List<MovieInfo> getMovieInfo(GetInternalApiRequest request) throws Exception;

}
