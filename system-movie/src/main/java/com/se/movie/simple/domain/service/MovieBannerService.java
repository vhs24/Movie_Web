package com.se.movie.simple.domain.service;

import java.util.List;

import com.se.movie.simple.domain.entity.MovieBanner;
import com.se.movie.simple.domain.payload.request.GetInternalApiRequest;

public interface MovieBannerService {

	List<String> save(List<MovieBanner> records) throws Exception;

	List<MovieBanner> getMovieBanner(GetInternalApiRequest request) throws Exception;

}
